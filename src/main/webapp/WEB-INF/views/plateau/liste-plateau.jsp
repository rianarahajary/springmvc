<%@ page import="org.naina.film.model.Plateau" %>
<%@ page import="java.util.List" %>
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
        <a href="liste-plateau" class="nav-link">Liste des plateaux</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="ajout-plateau" class="nav-link">Ajouter un plateau</a>
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
            <h1 class="m-0">Liste des plateaux</h1>
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
                  <% for (Plateau plateau:listePlateau) {%>
                  <tr>
                    <td><%=plateau.getIdPlateau()%></td>
                    <td><%=plateau.getNom()%></td>
                    <td>
                      <form action="edit-plateau" method="post" style="width: 100px">
                        <input type="hidden" name="idPlateau" value="<%=plateau.getIdPlateau()%>">
                        <input type="submit" class="btn btn-block btn-info btn-xs" value="Modifier">
                      </form>
                      <form action="delete-plateau" method="post" style="width: 100px">
                        <input type="hidden" name="idPlateau" value="<%=plateau.getIdPlateau()%>">
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
