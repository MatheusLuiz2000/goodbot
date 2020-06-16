<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
   <head>
      <title>The Good Bot - Editar Segmento</title>
      <c:set value="${pageContext.request.contextPath}" var="contextPath"/>
      <link href="${contextPath}/css/bootstrap.css" rel="stylesheet">
      <link href="${contextPath}/css/small-business.css" rel="stylesheet">
      <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
   </head>
   <style>
      input {
      width: 100%;
      }
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
            <div class="col-lg-12">
               <div class="well">
                  <h2 class="text-center mb-2">Editar o segmento ${segmentoModel.name}</h2>
                  <form:form modelAttribute="segmentoModel" action="${contextPath}/segmento/${segmentoModel.id_segment}" method="put">
                     <spring:hasBindErrors name="segmentoModel">
                        <div class="alert alert-danger" role="alert">
                           <form:errors path="*" class="has-error" />
                        </div>
                     </spring:hasBindErrors>
                     <div class="form-group">
                        <label class="control-label" for="name">Nome:</label>
                        <form:input type="text" path="name" id="name" class="form-control" maxlength="100" size="100" />
                        <font color="red">
                           <form:errors path="name"/>
                        </font>
                        <br/>
                     </div>
                     <div class="form-group">
                        <label class="control-label" for="bots">Bots:</label>
                        <form:select path="bot.id_bot">
                           <form:options items="${bots}" itemValue="id_bot" itemLabel="name" />
                        </form:select>
                     </div>
                     <hr>
                     <button type="submit" class="btn btn-primary btn-lg">Finalizar edição</button>
                     <br>
                     <br>
                  </form:form>
               </div>
            </div>
         </div>
      </div>
      <!-- jQuery -->
      <script src="${contextPath}/js/jquery.js"></script>
      <!-- Bootstrap Core JavaScript -->
      <script src="${contextPath}/js/bootstrap.min.js"></script>
   </body>
</html>