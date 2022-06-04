<div>
    <h3>Topics</h3>
    <ul>
        <li><a href="topics/all.do">All</a></li>

        <c:forEach items="${app.topicList.topics}" var="topic">
            <li>
                <a href="/topic${topic.url}">${topic.title} </a>
            </li>
        </c:forEach>
    </ul>

</div>
