<%@ page import="org.naina.film.model.Acteur" %>
<%@ page import="java.util.List" %>
<%@ page import="org.naina.film.model.Plateau" %>
<%@ page import="org.naina.film.model.Film" %>
<%@ include file="../layout/header.jsp" %>
<%
    List<Film> listeFilm = (List<Film>) request.getAttribute("listeFilm");
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
                <a href="liste-film" class="nav-link">Liste des films</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="ajout-film" class="nav-link">Ajouter un film</a>
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
                        <h1 class="m-0">Liste des films</h1>
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
                                        <th>Titre</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% for (Film film:listeFilm) {%>
                                    <form action="liste-scene" method="post">
                                        <tr>
                                            <td><%=film.getIdFilm()%></td>
                                            <td><%=film.getTitre()%></td>
                                            <td></td>
                                            <td>
                                                <input type="hidden" name="idFilm" value="<%=film.getIdFilm()%>">
                                                <input type="submit" value="Voir scenes">
                                            </td>
                                        </tr>
                                    </form>
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