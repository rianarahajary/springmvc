<%@ page import="org.naina.film.model.Acteur" %>
<%@ page import="java.util.List" %>
<%@ page import="org.naina.film.model.Plateau" %>
<%@ page import="org.naina.film.model.Film" %>
<%@ include file="../layout/header.jsp" %>
<%
    int idScene = (int) request.getAttribute("idScene");
    List<Acteur> listeActeur = (List<Acteur>) request.getAttribute("listeActeur");
    List<Plateau> listePlateau = (List<Plateau>) request.getAttribute("listePlateau");
%>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="ajout-scene" class="nav-link">Ajouter une scene</a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <%@ include file="../layout/sidebar.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <div class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">Modifier scene <%=idScene%></h1>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.container-fluid -->
        </div>
        <!-- /.content-header -->

        <!-- Main content -->
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <form class="form-horizontal" action="trait-edit-scene" method="post">
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label for="inputEmail3" class="col-sm-2 col-form-label">Nom de la scene</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="nom" class="form-control" id="inputEmail3" placeholder="Entrer le titre">
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label for="inputEmail3" class="col-sm-2 col-form-label">Heure favorable</label>
                                        <div class="col-sm-10">
                                            <input type="time" name="heureFav" class="form-control" id="inputEmail3" placeholder="Entrer le titre">
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label for="inputEmail3" class="col-sm-2 col-form-label">Duree</label>
                                        <div class="col-sm-10">
                                            <input type="number" name="duree" class="form-control" id="inputEmail3" placeholder="Entrer la Duree">
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Selectioner un plateau</label>
                                        <div class="col-sm-10">
                                            <select class="form-control" id="plateau" name="plateau" required="">
                                                <%
                                                    for (Plateau plateau : listePlateau) {
                                                %>
                                                <option value="<%= plateau.getIdPlateau()%>"> <%= plateau.getNom()%></option>
                                                <%} %>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <input type="hidden" name="idScene" value="<%=idScene%>">
                                    <input type="submit" class="btn btn-info" value="Valider">
                                    <button type="submit" class="btn btn-default float-right">Cancel</button>
                                </div>
                                <!-- /.card-footer -->
                            </form>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /.content -->
    </div>
    <footer class="main-footer">
        <strong>Copyright &copy; Riana Rahajary</strong>
        All rights reserved
    </footer>
    <!-- Main Footer -->
</div>
</body>