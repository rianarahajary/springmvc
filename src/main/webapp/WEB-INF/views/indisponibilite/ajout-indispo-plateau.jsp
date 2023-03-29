<%@ page import="java.util.List" %>
<%@ page import="org.naina.film.model.Plateau" %>
<%@ include file="../layout/header.jsp" %>
<%
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
                <a href="liste-indispo-plateau" class="nav-link">Liste des indisponibilites</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="ajout-indispo-plateau" class="nav-link">Ajouter indisponibilite</a>
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
                        <h1 class="m-0">Ajouter indisponibilite</h1>
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
                            <form class="form-horizontal" action="trait-ajout-indispo-plateau" method="post">
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Selectioner le plateau</label>
                                        <div class="col-sm-10">
                                            <select class="form-control" name="plateau">
                                                <%for(Plateau plateau:listePlateau){%>
                                                <option value="<%=plateau.getIdPlateau()%>"><%=plateau.getNom()%></option>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Date d'indisponibilite</label>
                                        <div class="col-sm-10">
                                            <input name="date" type="date" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Heure debut</label>
                                        <div class="col-sm-10">
                                            <input name="heureDebut" type="time" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Heure fin</label>
                                        <div class="col-sm-10">
                                            <input name="heureFin" type="time" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <input type="submit" class="btn btn-info" value="Valider"/>
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
    <!-- Main Footer -->
    <footer class="main-footer">
        <strong>Copyright &copy; Riana Rahajary</strong>
        All rights reserved
    </footer>
</div>
</body>