<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="personList.title"/></title>
    <meta name="heading" content="<fmt:message key='personList.heading'/>"/>
    <meta name="menu" content="PersonMenu"/>
</head>

<input type="button" style="margin-right: 5px" class="button"
        onclick="location.href='<c:url value="/editPerson.html"/>'"
        value="<fmt:message key="button.add"/>"/>
        
<br/>

<display:table name="persons" class="table" requestURI="" id="personList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="editPerson.html" media="html"
        paramId="id" paramProperty="id" titleKey="person.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="person.id"/>
    <display:column property="firstName" sortable="true" titleKey="person.firstName"/>
    <display:column property="lastName" sortable="true" titleKey="person.lastName"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="personList.person"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="personList.persons"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="personList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="personList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="personList.title"/>.pdf</display:setProperty>
</display:table>

<script type="text/javascript">
    highlightTableRows("personList");
</script>
