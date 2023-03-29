<%@ page import="java.util.List" %>
<%@ page import="org.naina.film.model.Suggestion" %>
<%@ include file="../layout/header.jsp" %>
<%
    List<Suggestion> listeSuggestion = (List<Suggestion>) request.getAttribute("listeSuggestion");
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
                        <h1 class="m-0">Suggestion planning du tournage</h1>
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
                                        <th>Date debut de tournage</th>
                                        <th>Date fin de tournage</th>
                                        <th>Nom de la scene</th>
                                        <th>Plateau</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%for(Suggestion suggestion : listeSuggestion){%>
                                    <tr>
                                        <td><%=suggestion.getIdSuggestion()%> </td>
                                        <td><%=suggestion.getDebutTournage()%></td>
                                        <td><%=suggestion.getFinTournage()%></td>
                                        <td><%=suggestion.getIdScene()%></td>
                                        <td>Plateau</td>
                                        <td><%=suggestion.getStatus()%></td>
                                        <td>
                                            <form action="valider-suggestion" method="post" style="width: 100px">
                                                <input type="hidden" name="idSuggestion" value="<%=suggestion.getIdSuggestion()%>">
                                                <input type="submit" class="btn btn-block btn-success btn-xs" value="Valider">
                                            </form>
                                            <form action="delete-suggestion" method="post" style="width: 100px">
                                                <input type="hidden" name="idSuggestion" value="<%=suggestion.getIdSuggestion()%>">
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