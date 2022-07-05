<%@ include file="/init.jsp" %>

<div class="container-fluid-1280">

    <h1><liferay-ui:message key="notifications" /></h1>

    <%-- Clay management toolbar. --%>

    <clay:management-toolbar
        disabled="${notificationCount eq 0}"
        displayContext="${notificationsManagementToolbarDisplayContext}"
        itemsTotal="${notificationCount}"
        searchContainerId="notificationEntries"
        selectable="false"
    />

    <%-- Search container. --%>

    <liferay-ui:search-container 
        emptyResultsMessage="no-notifications"
        id="notificationEntries"
        iteratorURL="${portletURL}" 
        total="${notificationCount}">

		<liferay-ui:search-container-results results="${notificationsUnRead}" />
        <liferay-ui:search-container-results results="${notificationsRead}" />

        <liferay-ui:search-container-row
            className="com.liferay.cyc.nexo.notification.model.Notification"
            modelVar="entry">

            <%@ include file="/notification/entry_search_columns.jspf" %>

        </liferay-ui:search-container-row>

        <%-- Iterator / Paging --%>

        <liferay-ui:search-iterator 
            displayStyle="${notificationsManagementToolbarDisplayContext.getDisplayStyle()}"
            markupView="lexicon" 
        />
    </liferay-ui:search-container>
</div>