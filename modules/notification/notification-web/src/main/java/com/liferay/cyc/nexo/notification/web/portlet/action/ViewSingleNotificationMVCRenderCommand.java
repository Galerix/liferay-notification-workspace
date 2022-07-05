package com.liferay.cyc.nexo.notification.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.cyc.nexo.notification.model.Notification;
import com.liferay.cyc.nexo.notification.service.NotificationService;
import com.liferay.cyc.nexo.notification.web.constants.NotificationPortletKeys;
import com.liferay.cyc.nexo.notification.web.constants.MVCCommandNames;

import java.text.DateFormat;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC Command for showing the assignment submissions list view.
 * 
 * @author David Galera
 */
@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + NotificationPortletKeys.NOTIFICATION,
        "mvc.command.name=" + MVCCommandNames.VIEW_NOTIFICATION
    },
    service = MVCRenderCommand.class
)

public class ViewSingleNotificationMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

            long notificationId = ParamUtil.getLong(renderRequest, "notificationId", 0);

            try {

                // Call the service to get the assignment.

                Notification notification =_notificationService.getNotification(notificationId);

                DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("EEEEE, MMMMM dd, yyyy", renderRequest.getLocale());

                // Set attributes to the request.

                renderRequest.setAttribute("notification", notification);
                renderRequest.setAttribute("createDate", dateFormat.format(notification.getCreateDate()));

                // Set back icon visible.

                PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

                String redirect = renderRequest.getParameter("redirect");

                portletDisplay.setShowBackIcon(true);
                portletDisplay.setURLBack(redirect);

                return "/notification/view_notification.jsp";

            }
            catch (PortalException pe) {
                throw new PortletException(pe);
            }
		
		
	}
	
    @Reference
    private NotificationService _notificationService;

    @Reference
    private Portal _portal;

    @Reference
    private UserLocalService _userLocalService;
	

}
