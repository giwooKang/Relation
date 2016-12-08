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
            <a class="toolbar-brand" href="#" style="font-weight: bold;">실시간 핫이슈</a>
        </div>
        <c:forEach var="item" items="${currentHot}">
            <p class="navdrawer-subheader"><a href="/search?keyword=${item}">${item}</a></p>
        </c:forEach>
    </div>
</nav>

<div class="jumbotron jumbotron-fluid mb-xl doc-jumbotron" id="doc_index_jumbotron">
    <div class="container">
        <div class="row">
            <div class="col-sm-10 col-md-8 col-xl-6 offset-sm-1 offset-md-2 offset-xl-3">
                <h5 class="typography-display-4">${keyword.keyword}</h5>
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
<%



%>
<script>
    var cy;

    $(function(){ // on dom ready

        cy = cytoscape({
            container: document.getElementById('cy'),

            style: [{"selector":"core","style":{"selection-box-color":"#AAD8FF","selection-box-border-color":"#8BB0D0","selection-box-opacity":"0.5"}},{"selector":"node","style":{"width":"mapData(score, 0, 0.006769776522008331, 20, 60)","height":"mapData(score, 0, 0.006769776522008331, 20, 60)","content":"data(name)","font-size":"12px","text-valign":"center","text-halign":"center","background-color":"#555","text-outline-color":"#555","text-outline-width":"2px","color":"#fff","overlay-padding":"6px","z-index":"10"}},{"selector":"node[?attr]","style":{"shape":"rectangle","background-color":"#aaa","text-outline-color":"#aaa","width":"16px","height":"16px","font-size":"6px","z-index":"1"}},{"selector":"node[?query]","style":{"background-clip":"none","background-fit":"contain"}},{"selector":"node:selected","style":{"border-width":"6px","border-color":"#AAD8FF","border-opacity":"0.5","background-color":"#77828C","text-outline-color":"#77828C"}},{"selector":"edge","style":{"curve-style":"haystack","haystack-radius":"0.5","opacity":"0.4","line-color":"#bbb","width":"mapData(weight, 0, 1, 1, 8)","overlay-padding":"3px"}},{"selector":"node.unhighlighted","style":{"opacity":"0.2"}},{"selector":"edge.unhighlighted","style":{"opacity":"0.05"}},{"selector":".highlighted","style":{"z-index":"999999"}},{"selector":"node.highlighted","style":{"border-width":"6px","border-color":"#AAD8FF","border-opacity":"0.5","background-color":"#394855","text-outline-color":"#394855","shadow-blur":"12px","shadow-color":"#000","shadow-opacity":"0.8","shadow-offset-x":"0px","shadow-offset-y":"4px"}},{"selector":"edge.filtered","style":{"opacity":"0"}},{"selector":"edge[group=\"coexp\"]","style":{"line-color":"#d0b7d5"}},{"selector":"edge[group=\"coloc\"]","style":{"line-color":"#a0b3dc"}},{"selector":"edge[group=\"gi\"]","style":{"line-color":"#90e190"}},{"selector":"edge[group=\"path\"]","style":{"line-color":"#9bd8de"}},{"selector":"edge[group=\"pi\"]","style":{"line-color":"#eaa2a2"}},{"selector":"edge[group=\"predict\"]","style":{"line-color":"#f6c384"}},{"selector":"edge[group=\"spd\"]","style":{"line-color":"#dad4a2"}},{"selector":"edge[group=\"spd_attr\"]","style":{"line-color":"#D0D0D0"}},{"selector":"edge[group=\"reg\"]","style":{"line-color":"#D0D0D0"}},{"selector":"edge[group=\"reg_attr\"]","style":{"line-color":"#D0D0D0"}},{"selector":"edge[group=\"user\"]","style":{"line-color":"#f0ec86"}}],

            elements: [${json}]
        });

        var params = {
            name: 'cola',
            nodeSpacing: 5,
            edgeLengthVal: 45,
            animate: true,
            randomize: false,
            maxSimulationTime: 1500
        };
        var layout = makeLayout();
        var running = false;

        cy.on('layoutstart', function(){
            running = true;
        }).on('layoutstop', function(){
            running = false;
        });

        layout.run();

        var $config = $('#config');
        var $btnParam = $('<div class="param"></div>');
        $config.append( $btnParam );

        var sliders = [
            {
                label: 'Edge length',
                param: 'edgeLengthVal',
                min: 1,
                max: 200
            },

            {
                label: 'Node spacing',
                param: 'nodeSpacing',
                min: 1,
                max: 50
            }
        ];

        var buttons = [
            {
                label: '<i class="fa fa-random"></i>',
                layoutOpts: {
                    randomize: true,
                    flow: null
                }
            },

            {
                label: '<i class="fa fa-long-arrow-down"></i>',
                layoutOpts: {
                    flow: { axis: 'y', minSeparation: 30 }
                }
            }
        ];

        sliders.forEach( makeSlider );

        buttons.forEach( makeButton );

        function makeLayout( opts ){
            params.randomize = false;
            params.edgeLength = function(e){ return params.edgeLengthVal / e.data('weight'); };

            for( var i in opts ){
                params[i] = opts[i];
            }

            return cy.makeLayout( params );
        }

        function makeSlider( opts ){
            var $input = $('<input></input>');
            var $param = $('<div class="param"></div>');

            $param.append('<span class="label label-default">'+ opts.label +'</span>');
            $param.append( $input );

            $config.append( $param );

            var p = $input.slider({
                min: opts.min,
                max: opts.max,
                value: params[ opts.param ]
            }).on('slide', _.throttle( function(){
                params[ opts.param ] = p.getValue();

                layout.stop();
                layout = makeLayout();
                layout.run();
            }, 16 ) ).data('slider');
        }

        function makeButton( opts ){
            var $button = $('<button class="btn btn-default">'+ opts.label +'</button>');

            $btnParam.append( $button );

            $button.on('click', function(){
                layout.stop();

                if( opts.fn ){ opts.fn(); }

                layout = makeLayout( opts.layoutOpts );
                layout.run();
            });
        }

        cy.nodes().forEach(function(n){
            var g = n.data('name');

            n.qtip({
                content: [
                    {
                        name: 'Google',
                        url: 'https://www.google.com/search?q=' + g
                    },
                    {
                        name: 'Naver',
                        url: 'https://search.naver.com/search.naver?query='+ g
                    },
                    {
                        name: 'Daum',
                        url: 'http://search.daum.net/search?w=tot&q=' + g
                    }
                ].map(function( link ){
                    return '<a target="_blank" href="' + link.url + '">' + link.name + '</a>';
                }).join('<br />\n'),
                position: {
                    my: 'top center',
                    at: 'bottom center'
                },
                style: {
                    classes: 'qtip-bootstrap',
                    tip: {
                        width: 16,
                        height: 8
                    }
                }
            });
        });

        $('#config-toggle').on('click', function(){
            $('body').toggleClass('config-closed');

            cy.resize();
        });

    }); // on dom ready

    $(function() {
        FastClick.attach( document.body );
    });





</script>
</html>
