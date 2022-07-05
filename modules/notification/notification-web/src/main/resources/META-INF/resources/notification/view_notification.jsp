 <%@ include file="../init.jsp"%>

 <div class="container-fluid-1280">

     <h1>${notification.getTitle(locale)}</h1>

     <h2><liferay-ui:message key="notification-information" /></h2>

     <div class="notification-metadata">

         <dl>
             <dt><liferay-ui:message key="created" /></dt>
             <dd>${createDate}</dd>

             <dt><liferay-ui:message key="created-by" /></dt>
             <dd>${notification.userName}</dd>

             <dt><liferay-ui:message key="description" /></dt>
             <dd>${notification.getDescription()}</dd>
         </dl>
     </div>
 </div>