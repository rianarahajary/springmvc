<%@ page import="org.naina.film.model.Acteur" %>
<%@ page import="java.util.List" %>
<%@ include file="../layout/header.jsp" %>
<%
    List<Acteur> listeActeur = (List<Acteur>) request.getAttribute("listeActeur");
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
                <a href="liste-acteur" class="nav-link">Liste des acteurs</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="ajout-acteur" class="nav-link">Ajouter un acteur</a>
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
                        <h1 class="m-0">Liste des acteurs</h1>
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
                            <div class="card-body table-responsive p-0">
                                <table class="table table-hover text-nowrap">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nom</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% for (Acteur acteur:listeActeur) {%>
                                    <tr>
                                        <td><%=acteur.getIdActeur()%></td>
                                        <td><%=acteur.getNom()%></td>
                                        <td>
                                            <form action="edit-acteur" method="post" style="width: 100px">
                                                <input type="hidden" name="idActeur" value="<%=acteur.getIdActeur()%>">
                                                <input type="submit" class="btn btn-block btn-info btn-xs" value="Modifier">
                                            </form>
                                            <form action="delete-acteur" method="post" style="width: 100px">
                                                <input type="hidden" name="idActeur" value="<%=acteur.getIdActeur()%>">
                                                <input type="submit" class="btn btn-block btn-danger btn-xs" value="Supprimer">
                                            </form>
                                        </td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
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