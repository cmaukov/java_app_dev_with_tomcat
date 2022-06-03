<%@ page import="com.jakarta.play.blog.ApplicationSettings" %>
<%@ page import="com.jakarta.play.blog.Topic" %>
<%@ page import="java.util.List" %>
<div>
    <h3>Topics</h3>
    <ul>
        <li><a href="topics/all.do">All</a></li>
        <%
            ApplicationSettings app = (ApplicationSettings) request.getServletContext().getAttribute("app");
            List<Topic> topics = app.getTopicList().getTopics();
            for (Topic topic : topics) {%>
        <li>
            <a href="/topic<%=topic.getUrl()%>"><%=topic.getTitle()%>
            </a>
        </li>

        <% }
        %>
    </ul>

</div>
