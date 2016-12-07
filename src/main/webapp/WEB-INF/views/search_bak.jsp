<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <!-- Compatibility for IE -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- Set viewport for N-Screen -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <!-- Development -->
    <meta name="robots" content="noindex, nofollow">
    <!-- Release -->
    <meta name="robots" content="index, follow">
    <title> HTML5 Template </title>
    <!-- favicon image -->
    <link rel="shortcut icon" href="favicon.png">

    <!-- css -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="/resources/css/material.min.css" rel="stylesheet">
    <link href="/resources/css/project.min.css" rel="stylesheet">
    <link href="/resources/css/common.css" rel="stylesheet">


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/4.10.3/css/bootstrap-slider.min.css">
    <link href="/resources/css/cy.css" rel="stylesheet">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link href="http://cdnjs.cloudflare.com/ajax/libs/qtip2/2.2.0/jquery.qtip.min.css" rel="stylesheet" type="text/css" />

</head>
<body>


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
                <h5 class="typography-display-4">Keyword</h5>
            </div>
        </div>
    </div>
</div>


<main class="doc-main" role="main" style="padding-bottom: 60px;">
    <div class="container">
        <div class="row">
            <div class="col-sm-10 col-md-10 col-xl-10 offset-sm-1 offset-md-1 offset-xl-1">
                <div class="col-sm-10 col-md-10 col-xl-10"><div id="cy"></div></div>
                <div class="col-sm-2 col-md-2 col-xl-2"><div id="config" class="config"></div></div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4 col-md-4 col-xl-4">
            </div>
            <div class="col-sm-4 col-md-4 col-xl-4">

            </div>
            <div class="col-sm-4 col-md-4 col-xl-4">

            </div>
        </div>
    </div>
</main>



</body>

<!-- js -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.3.7/js/tether.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/js/bootstrap.min.js"></script>
<script src="/resources/js/material.min.js"></script>
<script src="/resources/js/project.min.js"></script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/fastclick/1.0.6/fastclick.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/3.10.0/lodash.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/4.10.3/bootstrap-slider.min.js"></script>
<script src="http://marvl.infotech.monash.edu/webcola/cola.v3.min.js"></script>
<script src="http://cytoscape.github.io/cytoscape.js/api/cytoscape.js-latest/cytoscape.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/qtip2/2.2.0/jquery.qtip.min.js"></script>
<script src="https://cdn.rawgit.com/cytoscape/cytoscape.js-qtip/2.2.5/cytoscape-qtip.js"></script>
<script src="https://cdn.rawgit.com/cytoscape/cytoscape.js-cola/1.1.1/cytoscape-cola.js"></script>

<script src="/resources/js/cy.js"> </script>
</html>
