<div class="toolbar toolbar-waterfall toolbar-dark doc-toolbar" id="doc_index_toolbar">
    <a class="toolbar-toggler float-xs-left hidden-lg-up" data-toggle="navdrawer" data-type="permanent" href="#doc_index_navdrawer_menu"><i class="sr-only">menu</i></a>
    <a class="toolbar-brand hidden-lg-up" href="index.html">Material</a>
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
            <a class="toolbar-brand" href="index.html">Material</a>
        </div>
        <p class="navdrawer-subheader">More to come...</p>
    </div>
</nav>

<div class="jumbotron jumbotron-fluid mb-xl doc-jumbotron" id="doc_index_jumbotron">
    <div class="container">
        <div class="row">
            <div class="col-sm-10 col-md-8 col-xl-6 offset-sm-1 offset-md-2 offset-xl-3">
                <h1 class="typography-display-4">Material</h1>
                <p class="font-weight-light typography-title">Daemonite's Material UI is a cross-platform and fully responsive front-end interface based on Google Material Design, built using Bootstrap 4.</p>
                <p><a class="btn btn-lg btn-secondary" data-toggle="modal" href="#doc_index_modal_download">Download Material</a></p>
                <p class="mb-no text-white-hint typography-caption">Currently v4.0.0-alpha.2<br>(based on Bootstrap v4.0.0-alpha.5)</p>
            </div>
        </div>
    </div>
</div>

<div class="dialog fade" id="doc_index_modal_download" tabindex="-1">
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

<main class="doc-main" id="doc_index_main" role="main">
    <div class="container">
        <div class="row">
            <div class="col-sm-10 col-md-8 col-xl-6 offset-sm-1 offset-md-2 offset-xl-3">
                <div class="mb-xl">
                    <h2 class="text-primary">Introduction</h2>
                    <p class="typography-subheading">The basic idea behind this project is to combine the visual language of <a href="https://material.google.com/" target="_blank">Google Material Design<sup><i class="material-icons material-icons-inline">open_in_new</i></sup></a> with the front-end technology of the popular <a href="https://v4-alpha.getbootstrap.com/" target="_blank">Bootstrap<sup><i class="material-icons material-icons-inline">open_in_new</i></sup></a> framework.</p>
                </div>

                <div class="blockquote mb-xl">
                    <p class="font-weight-light text-muted">Contents</p>
                    <p><a href="#doc_index_content_goals">Goals</a></p>
                    <p><a href="#doc_index_content_principles">Principles</a></p>
                    <p><a href="#doc_index_content_roadmap">Roadmap</a></p>
                </div>

                <div class="mb-xl" id="doc_index_content_goals">
                    <h3 class="text-primary">Goals</h3>
                    <div class="row">
                        <div class="col-md-6 mt-lg">
                            <h4 class="text-secondary typography-subheading">Primary</h4>
                            <p>The primary goal of this project is to give all Bootstrap components and elements a Material Design look, so it allows web developers to continue using the exact same Bootstrap HTML markup they are familiar with, but presents a final outcome that is in line with the principles and specifics of Google Material Design.</p>
                            <p>Therefore, the Bootstrap's <a href="https://v4-alpha.getbootstrap.com/getting-started/introduction/" target="_blank">documentation<sup><i class="material-icons material-icons-inline">open_in_new</i></sup></a> can serve as a valid documentation for this project as well. Replacing <code>bootstrap.min.css</code> on the site with <code>material.min.css</code> from this project without any other changes will transform all components and elements into a materialised look.</p>
                        </div>
                        <div class="col-md-6 mt-lg">
                            <h4 class="text-secondary typography-subheading">Secondary</h4>
                            <p>A secondary goal of this project is to add support of some unique Material Design components such as floating action buttons, pickers and steppers to name a few, which cannot be achieved by transforming existing Bootstrap components or elements.</p>
                            <p>Because these components will require additional markup (some may require additional JavaScript), they will be documented separately in Material's documentation (work-in-progress).</p>
                        </div>
                    </div>
                </div>

                <div class="mb-xl" id="doc_index_content_principles">
                    <h3 class="text-primary">Principles</h3>
                    <div class="row">
                        <div class="col-md-6 mt-lg">
                            <h4 class="text-secondary typography-subheading">CSS &amp; HTML</h4>
                            <p>If a Bootstrap component has an exact match in Google Material Design, this project will style this Bootstrap component based on the specifications laid out in Google Material Design Guidelines. For example, Bootstrap's buttons = Google Material Design's buttons.</p>
                            <p>Some of the Bootstrap components seem to lack an exact match in Google Material Design, but this may simply due to different naming conventions. In this case, this project will not only style this Bootstrap component based on the specifications laid out in Google Material Design Guidelines, it will also add an additional CSS selector that is in line with Google Material Design naming convention on top of Bootstrap's CSS selector. For example, Bootstrap's navbars = Google Material Design's toolbars, so <code>.navbar</code> &amp; <code>.navbar-*</code> will act the same as <code>.toolbar</code> &amp; <code>.toolbar-*</code> respectively.</p>
                            <p>If a Bootstrap component does not have an exact match in Google Material Design, the specifications of a closest matching component in Google Material Design Guidelines will be used to style this Bootstrap component. For example, Bootstrap's tags = Google Material Design's chips.</p>
                            <p>If a Bootstrap component lacks a related counterpart in Google Material Design completely, this project will style this component based on custom iteration of Google Material Design Guidelines. For example, Bootstrap's button groups, jumbotrons and paginations, etc.</p>
                        </div>
                        <div class="col-md-6 mt-lg">
                            <h4 class="text-secondary typography-subheading">JavaScript</h4>
                            <p>No modification has been made to Bootstrap's JavaScript. It is safe to use Bootstrap's JavaScript as it is.</p>
                            <p>However, in order to achieve some Material feel and look, Material includes a handful of additional JavaScript to help bring some of the components to life.</p>
                        </div>
                    </div>
                </div>

                <div class="mb-xl" id="doc_index_content_roadmap">
                    <h3 class="text-primary">Roadmap</h3>
                    <div class="row">
                        <div class="col-md-4 mt-lg">
                            <h4 class="text-secondary typography-subheading">Near-term</h4>
                            <p>Bug fixes and updates alongside Bootstrap 4's continuous releases.</p>
                        </div>
                        <div class="col-md-4 mt-lg">
                            <h4 class="text-secondary typography-subheading">Mid-term</h4>
                            <p>Add missing support for some Google Material Design components (e.g. snackbars).</p>
                        </div>
                        <div class="col-md-4 mt-lg">
                            <h4 class="text-secondary typography-subheading">Long-term</h4>
                            <p>Rewrite all JavaScript plugins in ES6 to take advantage of the newest JavaScript enhancements.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>