<%@ page import="java.util.List" %>
<%@ page import="org.naina.film.model.Scene" %>
<%@ page import="org.naina.film.model.Acteur" %>
<%@ page import="org.naina.film.model.SceneActeur" %>
<%@ page import="org.naina.film.service.ActeurService" %>
<%@ page import="org.naina.film.service.PlateauService" %>
<%@ include file="../layout/header.jsp" %>
<%
  List<Scene> listeScene = (List<Scene>) request.getAttribute("listeScene");
  List<SceneActeur> listeSceneActeur = (List<SceneActeur>) request.getAttribute("listeSceneActeur");
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
            <h1 class="m-0">Liste des scenes</h1>
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
                    <th>Nom de la scene</th>
                    <th>Titre du film</th>
                    <th>Heure favorable</th>
                    <th>Duree</th>
                    <th>idPlateau</th>
                    <th>idActeurs</th>
                    <th>Status</th>
                    <th>Action</th>
                  </tr>
                  </thead>
                  <tbody>
                  <% for(Scene scene : listeScene){%>
                  <tr>
                    <td><%=scene.getIdScene()%></td>
                    <td><%=scene.getNom()%></td>
                    <td><%=scene.getIdFilm()%></td>
                    <td><%=scene.getHeureFav()%></td>
                    <td><%=scene.getDuree()%> min</td>
                    <td><%=scene.getIdPlateau()%></td>
                    <td>
                      <%for(SceneActeur sa:listeSceneActeur){
                      if(sa.getIdScene()==scene.getIdScene()){
                      %>
                      <%=sa.getIdActeur()%> <br/>
                      <%}}%>
                    </td>
                    <td><%=scene.getStatus()%></td>
                    <td>
                      <form action="planification" method="post" style="width: 100px">
                        <input type="hidden" name="idScene" value="<%=scene.getIdScene()%>">
                        <input type="submit" class="btn btn-block btn-success btn-xs" value="Planifier">
                      </form>
                      <form action="edit-scene" method="post" style="width: 100px">
                        <input type="hidden" name="idScene" value="<%=scene.getIdScene()%>">
                        <input type="submit" class="btn btn-block btn-info btn-xs" value="Modifier">
                      </form>
                      <form action="delete-scene" method="post" style="width: 100px">
                        <input type="hidden" name="idScene" value="<%=scene.getIdScene()%>">
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
  <footer class="main-footer">
    <strong>Copyright &copy; Riana Rahajary</strong>
    All rights reserved
  </footer>
  <!-- Main Footer -->
</div>
</body>