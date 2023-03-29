<%@ page import="java.util.List" %>
<%@ page import="org.naina.film.model.IndispoPlateau" %>
<%@ include file="../layout/header.jsp" %>
<%
    List<IndispoPlateau> listeIndispoPlateau = (List<IndispoPlateau>) request.getAttribute("listeIndispoPlateau");
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
                        <h1 class="m-0">Indisponibilites plateau</h1>
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
                                        <th>Plateau</th>
                                        <th>Date d'indisponibilite</th>
                                        <th>Heure debut</th>
                                        <th>Heure fin</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%for(IndispoPlateau indispoPlateau : listeIndispoPlateau){%>
                                    <tr>
                                        <td><%=indispoPlateau.getIdIndispoPlateau()%></td>
                                        <td><%=indispoPlateau.getIdPlateau()%></td>
                                        <td><%=indispoPlateau.getDate()%></td>
                                        <td><%=indispoPlateau.getHeureDebut()%></td>
                                        <td><%=indispoPlateau.getHeureFin()%></td>
                                        <td>
                                            <form action="delete-indispo-plateau" method="post" style="width: 100px">
                                                <input type="hidden" name="idIndispoPlateau" value="<%=indispoPlateau.getIdIndispoPlateau()%>">
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