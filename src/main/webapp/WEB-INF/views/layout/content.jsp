<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="toolbar toolbar-waterfall toolbar-dark doc-toolbar" id="doc_index_toolbar">
    <a class="toolbar-toggler float-xs-left hidden-lg-up" data-toggle="navdrawer" data-type="permanent" href="#doc_index_navdrawer_menu"><i class="sr-only">menu</i></a>
    <a class="toolbar-brand hidden-lg-up" href="/">Rel</a>
    <div class ="float-xs-left col-md-4">
        <form action="/" method="get">
            <input type="text" class="form-control" placeholder="Search...">
        </form>
    </div>

    <div class="dropdown float-xs-right">
        <a class="navbar-toggler mr-no text-white" data-toggle="dropdown" href="javascript:void(0)" style="background-image: none;"><i class="material-icons">more_vert</i></a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="https://github.com/Daemonite/material" target="_blank"><i class="material-icons mr-md">code</i><span class="mr-md">Fork me on GitHub</span></a>
            <a class="dropdown-item" href="http://labs.daemon.com.au/" target="_blank"><i class="material-icons mr-md">forum</i><span class="mr-md">Let us know what you think</span></a>
        </div>
    </div>

</div>

<nav class="navdrawer navdrawer-permanent" id="doc_index_navdrawer_menu">
    <div class="navdrawer-content">
        <div class="toolbar toolbar-bordered">
            <a class="toolbar-brand" href="#" style="font-weight: bold;">최근 검색어</a>
        </div>
        <p class="navdrawer-subheader"><a href="">More to come...</a></p>
    </div>
</nav>

<div class="jumbotron jumbotron-fluid mb-xl doc-jumbotron" id="doc_index_jumbotron">
    <div class="container">
        <div class="row">
            <div class="col-sm-10 col-md-8 col-xl-6 offset-sm-1 offset-md-2 offset-xl-3">
                <h1 class="typography-display-4">Rel</h1>
                <p class="font-weight-light typography-title">구글, 네이버, 다음 등 검색엔진에서 핫이슈들을 참고하고 그와 관련된 키워드들을 취합하여, 보기쉽게 보여줍니다.</p>
                <p><a class="btn btn-lg btn-secondary" data-toggle="modal" href="#help">도움말</a></p>
                <p class="mb-no text-white-hint typography-caption"></p>
            </div>
        </div>
    </div>
</div>

<div class="dialog fade" id="help" tabindex="-1">
    <div class="dialog-dialog">
        <div class="dialog-content">
            <div class="dialog-header">
                <h2 class="dialog-title">Download</h2>
            </div>
            <div class="dialog-body">
                <p>Material v4.0.0-alpha.2 is available for download in several ways, including some of the favourite package managers.</p>
                <h3 class="mt-lg typography-subheading">Material CSS and JS</h3>
                <p>Download Material's ready-to-use code to easily drop into any project. Includes compiled and minified versions of CSS and JS plugins.</p>
                <p><a class="btn btn-flat-primary" href="https://github.com/Daemonite/material/releases" target="_blank">Download Material</a></p>
                <h3 class="mt-lg typography-subheading">Package Managers</h3>
                <p>Pull in Material's source files into nearly any project with some of the most popular package managers.</p>
                <pre class="p-a-md">
<code>npm install daemonite-material@4.0.0-alpha.2</code>
</pre>
                <pre class="p-a-md">
<code>bower install daemonite-material#4.0.0-alpha.2</code>
</pre>
            </div>
        </div>
    </div>
</div>

<main class="doc-main" id="main" role="main" style="padding-bottom: 60px;">
    <div class="container">
        <div class="row">
            <div class="col-sm-10 col-md-10 col-xl-10 offset-sm-1 offset-md-1 offset-xl-1">
                <c:forEach var="item" items="${hotkeywords}">
                    <div class="col-xl-2 col-md-4 sm-6 mt-lg main_image" data-keyword="${item.keyword}">
                        <a href="/"><img src="${item.image}" alt="" class="img-thumbnail img-fluid"></a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</main>