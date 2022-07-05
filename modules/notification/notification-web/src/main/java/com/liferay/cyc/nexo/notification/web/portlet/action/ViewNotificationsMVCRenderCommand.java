package com.liferay.cyc.nexo.notification.web.portlet.action;

import com.liferay.cyc.nexo.notification.model.Notification;
import com.liferay.cyc.nexo.notification.service.NotificationService;
import com.liferay.cyc.nexo.notification.web.constants.MVCCommandNames;
import com.liferay.cyc.nexo.notification.web.constants.NotificationPortletKeys;
import com.liferay.cyc.nexo.notification.web.display.context.NotificationsManagementToolbarDisplayContext;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**
 * MVC command for showing the assignments list.
 * 
 * @author DGR
 */
@Component(
    immediate = true, 
    property = {
        "javax.portlet.name=" + NotificationPortletKeys.NOTIFICATION, 
        "mvc.command.name=/",
        "mvc.command.name=" + MVCCommandNames.VIEW_NOTIFICATIONS
    }, 
    service = MVCRenderCommand.class
)
public class ViewNotificationsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		//Add Notification list related attributes
		
		try {
			addNotificationListAttributes(renderRequest);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Add Clay management toolbar related attributes
		
		addManagementToolbarAttributes(renderRequest, renderResponse);
		
		return "/view.jsp";
	}


	private void addNotificationListAttributes(RenderRequest renderRequest) throws PortalException {
		
		
		//Resolve start and end for the search
		
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);

		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;
		
		// Get sorting options.
        // Notice that this doesn't really sort on title because the field is
        // stored in XML. In real world this search would be integrated to the
        // search engine  to get localized sort options.

        String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "title");
        String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");

        // Create comparator

        OrderByComparator<Notification> comparator = OrderByComparatorFactoryUtil.create("Notification", orderByCol, !("asc").equals(orderByType));

        // Get keywords.
        // Notice that cleaning keywords is not implemented.

        String keywords = ParamUtil.getString(renderRequest, "keywords");
        
        
        
        // Get serviceContext for getting the userToId
        ServiceContext serviceContext = ServiceContextFactory.getInstance(Notification.class.getName(), renderRequest);
        

        
        long toUserId = serviceContext.getUserId();
        
        
        // Call the service to get the list of assignments.

        List<Notification> notificationsRead = _notificationService.getNotificationsbyKeyWords(toUserId, true, keywords, start, end, comparator);
        List<Notification> notificationsUnRead = _notificationService.getNotificationsbyKeyWords(toUserId, false, keywords, start, end, comparator);

        long notificationsCount = _notificationService.getNotificationsCountByKeywords(toUserId, true, keywords);
        // Set request attributes.

        renderRequest.setAttribute("notificationsUnRead", notificationsUnRead);
        renderRequest.setAttribute("notificationsRead", notificationsRead);
        
        renderRequest.setAttribute("notificationCount", notificationsCount);
        
        	
	}
	
	private void addManagementToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);

        LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);

        NotificationsManagementToolbarDisplayContext notificationsManagementToolbarDisplayContext = new NotificationsManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));

        renderRequest.setAttribute("notificationsManagementToolbarDisplayContext", notificationsManagementToolbarDisplayContext);

		
	}
	
	@Reference
	protected NotificationService _notificationService;
	@Reference
    private Portal _portal;

}
