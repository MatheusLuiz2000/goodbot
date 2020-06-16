<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
   <head>
      <title>The Good Bot - Listagem de Segmentos</title>
      <c:set value="${pageContext.request.contextPath}" var="contextPath"/>
      <link href="${contextPath}/css/bootstrap.css" rel="stylesheet">
      <link href="${contextPath}/css/small-business.css" rel="stylesheet">
      <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
   </head>
   <style>
      #lista {
      margin-bottom: 20px;
      }
      #lista li {
      display: flex;
      align-items: center;
      padding: 15px;
      margin: 0px 20px;
      box-shadow: 0 19px 38px rgba(255, 255, 255, 0.3), 0 15px 12px rgba(84, 84, 84, 0.22);
      }
      #lista i {
      font-size: 30px;
      }
   </style>
   <body>
      <div class="container">
         <ul class="nav navbar-nav" id="lista">
            <li>
               <i class="fa fa-android" aria-hidden="true"></i>
               <a href="${contextPath}/bot">Bots</a>
            </li>
            <li>
               <i class="fa fa-id-card-o" aria-hidden="true"></i>
               <a href="${contextPath}/segmento">Segmentos</a>
            </li>
         </ul>
         <div class="row">
            <div class="col-md-12">
               <h1 class="text-center">The Good Bot - Listagem de Segmentos</h1>
               <p class="toolbar">
               <c:choose>
				    <c:when test="${not empty bots}">
				      <a class="btn btn-primary" href="${contextPath}/segmento/form?page=segmento-novo">Criar novo Segmento</a>
				    </c:when>    
				    <c:otherwise>
				        <h4 style="color:red;">Você deve criar um bot antes de criar um segmento!</h4>
				    </c:otherwise>
				</c:choose>
                  
                  <span class="alert"></span>
               </p>
               <c:if test="${not empty messages}">
                  <h3 class="alert alert-warning">${messages}</h3>
               </c:if>
               <c:choose>
                  <c:when test="${not empty segmentos}">
                     <table class="table table-striped">
                        <thead>
                           <tr>
                              <th data-field="nome">Nome</th>
                              <th data-field="bot">Bot</th>
                              <th class="actions" width="190">Ações</th>
                           </tr>
                        </thead>
                        <tbody>
                           <c:forEach items="${segmentos}" var="segmento">
                              <tr>
                                 <td>${segmento.name}</td>
                                 <td>${segmento.bot.name}</td>
                                 <td class="actions">
                                    <form:form action="${contextPath}/segmento/${segmento.id_segment}" method="delete">
                                       <a class="btn btn-warning btn-xs" href="${contextPath}/segmento/form?page=segmento-editar&id=${segmento.id_segment}">Editar</a>
                                       <input type="submit" value="Excluir" class="btn btn-danger btn-xs">
                                    </form:form>
                                 </td>
                              </tr>
                           </c:forEach>
                        </tbody>
                     </table>
                  </c:when>
                  <c:otherwise>
                     <h2 class="text-center">Não há segmentos cadastrados.</h2>
                  </c:otherwise>
               </c:choose>
            </div>
         </div>
         <hr>
      </div>
      <!-- jQuery -->
      <script src="${contextPath}/js/jquery.js"></script>
      <!-- Bootstrap Core JavaScript -->
      <script src="${contextPath}/js/bootstrap.min.js"></script>
   </body>
</html>