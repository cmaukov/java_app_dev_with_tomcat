<%@ page import="com.jakarta.play.blog.NewsItem" %>
<%@ page import="java.util.List" %>
<div class="p-3 border bg-light">

    <%
        List<NewsItem> items = (List<NewsItem>) request.getAttribute("items");
    %>
    <% for (NewsItem item : items) {
//    request.setAttribute("item", item);
        // we could use it in the page context only - request is available for all pages
    pageContext.setAttribute("item", item);
    %>

    <div>
        <h2> <a href="/news/${item.title}.do">${item.title} </a></h2>
        <div>
           ${item.entry}
        </div>
    </div>
    <% } %>

</div>