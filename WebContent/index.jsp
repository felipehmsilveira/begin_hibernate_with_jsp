<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.*,
		classes.Cliente,
		fachada.Fachada"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Restaurante Felipe Monteiro</title>
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/javascript.js"></script> 
  <!-- Bootstrap core CSS-->
  <link href="tmp/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="tmp/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="tmp/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="tmp/css/sb-admin.css" rel="stylesheet">
  <link rel="stylesheet" href="styles/style.css">

</head>
<script>
</script>
<body class="fixed-nav sticky-footer bg-dark sidenav-toggled" id="page-top">
  <!-- Navigation-->
  
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header row">
          <div class="col md-6">
          <i class="fa fa-truck"></i> Clientes 
          </div>
          <div class="col md-6 text-right">
          </div>
          </div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Nome</th>
                  <th>Data De Nascimento</th>
                  <th>Email</th>
                  <th>Facebook</th>
                  <th>Twitter</th>
                </tr>
              </thead>
              <tbody>
             <%
                Fachada fachada = Fachada.getInstancia();
                List<Cliente> clientes = fachada.listarCliente();       
                    
                for (Cliente cliente : clientes) {
              %>
                <tr>
                  
                 <td class="hidden-xs"> <%= cliente.getId() %> </td>
                 <td> <%= cliente.getNome() %> </td>
                <td> <%= cliente.getDatadenascimento() %> </td>
                <td> <%= cliente.getEmail() %> </td>
                <td> <%= cliente.getPaginanofacebook() %> </td>
                <td> <%= cliente.getUsuariodotwitter() %> </td>
                </tr>
                <%
                  }
                %>
              </tbody>
            </table>
          </div>
        </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © FenixWeb 1.0v</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Cadastro Modal-->
    <div class="modal fade" id="modal-mensagem" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Cadastro Cliente</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">
          <form class="center-form" method="post"
                  action="cadastroCliente">

                  <div class="form-group">
                    <div class="cols-sm-10">
                      <div class="input-group">
                        <span class="input-group-addon"><i
                          class="fa fa-user fa" aria-hidden="true"></i></span> <input
                          type="text" class="form-control" name="nome" id="name"
                          placeholder="Nome Completo" />
                      </div>
                    </div>
                  </div>

                  <div class="form-group">
                    <div class="cols-sm-10">
                      <div class="input-group">
                        <span class="input-group-addon"><i
                          class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
                          type="email" class="form-control" name="email" id="email"
                          placeholder="Email" />
                      </div>
                    </div>
                  </div>

                  <div class="form-group">
                    <div class="cols-sm-10">
                      <div class="input-group">
                        <span class="input-group-addon"><i
                          class="fa fa-phone fa" aria-hidden="true"></i></span> <input
                          type="text" class="form-control" name="datadenascimento"
                          id="telefone" placeholder="Data de nascimento" />
                      </div>
                    </div>
                  </div>


                  <div class="form-group">
                    <div class="cols-sm-10">
                      <div class="input-group">
                        <span class="input-group-addon"><strong><i
                            class="fa fa-map-marker fa-lg" aria-hidden="true"></i></strong></span> <input
                          type="text" class="form-control" name="cep" id="cep"
                          placeholder="CEP" />
                      </div>
                    </div>
                  </div>

                  <div class="form-group">

                    <div class="cols-sm-10">
                      <div class="input-group">
                        <span class="input-group-addon"><i
                          class="fa fa-map-marker fa-lg" aria-hidden="true"></i></span> <input
                          type="text" class="form-control" name="rua" id="rua"
                          placeholder="Rua" />
                      </div>
                    </div>
                  </div>

                  <div class="form-group">
                    <div class="cols-sm-10">
                      <div class="input-group">
                        <span class="input-group-addon"><i
                          class="fa fa-map-marker fa-lg" aria-hidden="true"></i></span> <input
                          type="text" class="form-control" name="bairro" id="bairro"
                          placeholder="Bairro" />
                      </div>
                    </div>
                  </div>

                  <div class="form-group">
                    <div class="cols-sm-10">
                      <div class="input-group">
                        <span class="input-group-addon"><i
                          class="fa fa-map-marker fa-lg" aria-hidden="true"></i></span> <input
                          type="text" class="form-control" name="cidade" id="cidade"
                          placeholder="Cidade" />
                      </div>
                    </div>
                  </div>

                  <div class="form-group">
                    <div class="cols-sm-10">
                      <div class="input-group">
                        <span class="input-group-addon"><i
                          class="fa fa-map-marker fa-lg" aria-hidden="true"></i></span> <input
                          type="text" class="form-control" name="numero" id="numero"
                          placeholder="Numero" />
                      </div>
                    </div>
                  </div>

                  <div class="form-group ">
                    <button type="submit"
                      class="btn btn-primary btn-lg btn-block login-button">Cadastrar</button>
                  </div>
                </form>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="tmp/vendor/jquery/jquery.min.js"></script>
    <script src="tmp/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="tmp/vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="tmp/vendor/datatables/jquery.dataTables.js"></script>
    <script src="tmp/vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="tmp/js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="tmp/js/sb-admin-datatables.min.js"></script>
    <script type="text/javascript" src="js/javascript.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
  </div>
</body>

</html>