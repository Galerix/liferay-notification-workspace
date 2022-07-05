<%@ include file="../init.jsp"%>

 <c:set var="notification" value="${SEARCH_CONTAINER_RESULT_ROW.object}" />

 <liferay-ui:icon-menu markupView="lexicon">

     <%-- View action. --%>

     <portlet:renderURL var="viewNotificationURL">
         <portlet:param name="mvcRenderCommandName"
             value="<%=MVCCommandNames.VIEW_NOTIFICATION%>" />
         <portlet:param name="redirect" value="${currentURL}" />
         <portlet:param name="notificationId" value="${notification.notificationId}" />
     </portlet:renderURL>

     <liferay-ui:icon message="view" url="${viewNotificationURL}" />

     <%-- Edit action. --%>

     <portlet:renderURL var="editNotificationURL">
         <portlet:param name="mvcRenderCommandName"
             value="<%=MVCCommandNames.EDIT_NOTIFICATION%>" />
         <portlet:param name="redirect" value="${currentURL}" />
         <portlet:param name="notificationId" value="${notification.notificationId}" />
     </portlet:renderURL>

     <liferay-ui:icon message="edit" url="${editNotificationURL}" />    

     <%-- Delete action. --%>

     <portlet:actionURL name="<%=MVCCommandNames.DELETE_NOTIFICATION%>" var="deleteNotificationURL">
         <portlet:param name="redirect" value="${currentURL}" />
         <portlet:param name="notificationId" value="${notification.notificationId}" />
     </portlet:actionURL>

     <liferay-ui:icon-delete url="${deleteNotificationtURL}" />

 </liferay-ui:icon-menu>