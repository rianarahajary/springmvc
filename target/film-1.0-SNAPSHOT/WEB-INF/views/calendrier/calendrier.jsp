<%@ include file="../layout/header.jsp" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="org.naina.film.model.Suggestion" %>
<%@ page import="java.time.ZoneId" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
  List<Suggestion> listeSuggestion = (List<Suggestion>) request.getAttribute("listeSuggestion");
  Calendar calendar = Calendar.getInstance();
  calendar.set(Calendar.YEAR,(int)request.getAttribute("year"));
  calendar.set(Calendar.MONTH, (int) request.getAttribute("month"));
  calendar.set(Calendar.DAY_OF_MONTH, 1);
  int month = calendar.get(Calendar.MONTH);
  int year = calendar.get(Calendar.YEAR);
  String[] daysOfWeek = {"DIM","LUN", "MAR", "MER", "JEU", "VEND", "SAT"};
  String[] monthList = {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout","Sept","Oct","Nov","Dec"};

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
            <h1 class="m-0">Calendrier de tournage</h1>
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
              <form class="form-horizontal" action="changeMonth" method="post">
                <div class="card-body">
                  <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Annee:</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="year">
                          <%for(int i=2023;i<2026;i++){%>
                          <option value="<%=i%>"><%=i%></option>
                          <%}%>
                        </select>
                    </div>
                  </div>
                  <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Mois:</label>
                    <div class="col-sm-2">
                      <select class="form-control" name="month">
                        <%for(int i=0;i<monthList.length;i++){%>
                        <option value="<%=i%>"><%=monthList[i]%></option>
                        <%}%>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="card-footer">
                  <input type="submit" class="btn btn-info float-right" value="Voir">
                </div>
              </form>
            </div>
          </div>
        </div>
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Mois de
              <%= monthList[(int) request.getAttribute("month")] %> -
              <%= (int) request.getAttribute("year")%></h1>
          </div><!-- /.col -->
        </div><!-- /.row -->
        <div class="row">
          <div class="col-12">
            <div class="card">
              <div class="card-body table-responsive p-0">
                <table class="table table-hover text-nowrap">
                  <thead>
                  <tr>
                    <th>Jour</th>
                    <th>Date</th>
                    <th>Evenement</th>
                  </tr>
                  </thead>
                  <tbody>
                  <%
                    while (calendar.get(Calendar.MONTH) == month) { %>
                  <% for (int i = 0; i < 7; i++) { %>
                  <tr>
                    <%
                      Date date = calendar.getTime();
                      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                      String formattedDate = sdf.format(date);
                    %>
                    <td>
                      <%= daysOfWeek[date.getDay()]%>
                    </td>
                    <td>
<%--                      <%= date.getDate() %>--%>
                      <%=formattedDate%>
                    </td>
                    <td>
                      <%-- Event --%>
                      <%
                        LocalDate convertedDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                        if(dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY){
                        for(Suggestion suggestion:listeSuggestion){
                          if(convertedDate.isAfter(suggestion.getDebutTournage())
                            && convertedDate.isBefore(suggestion.getFinTournage())
                                  || convertedDate.isEqual(suggestion.getDebutTournage())
                                  || convertedDate.isEqual(suggestion.getFinTournage())
                          )
                          {%>
                        Tournage scene:<%=suggestion.getIdScene()%> <br/>
                        <%}}}
                      %>
                    </td>
                    <% calendar.add(Calendar.DAY_OF_MONTH, 1);
                      if (calendar.get(Calendar.MONTH) != month) break; %>
                  </tr>
                  <% } %>
                  <% } %>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <footer class="main-footer">
    <strong>Copyright &copy; Riana Rahajary</strong>
    All rights reserved
  </footer>
</div>
</body>