<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>">
	<!-- 下拉框 -->
	<link rel="stylesheet" href="static/ace/css/chosen.css" />
	<!-- jsp文件头和头部 -->
	<%@ include file="../../system/index/top.jsp"%>
	<!-- 日期框 -->
	<link rel="stylesheet" href="static/ace/css/datepicker.css" />
</head>
<body class="no-skin">
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
	<!-- /section:basics/sidebar -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
					
					<form action="outline/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="OUTLINE_ID" id="OUTLINE_ID" value="${pd.OUTLINE_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">外线号码:</td>
								<td><input type="text" name="USERNAME" id="USERNAME" value="${pd.USERNAME}" maxlength="255" placeholder="这里输入外线号码" title="外线号码" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">服务器地址:</td>
								<td><input type="text" name="REALM" id="REALM" value="${pd.REALM}" maxlength="255" placeholder="这里输入服务器地址" title="服务器地址" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">注册密码:</td>
								<td><input type="text" name="PASSWORD" id="PASSWORD" value="${pd.PASSWORD}" maxlength="255" placeholder="这里输入注册密码" title="注册密码" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">是否注册:</td>
								<td><input type="text" name="REGISTER" id="REGISTER" value="${pd.REGISTER}" maxlength="255" placeholder="这里输入是否注册" title="是否注册" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">外线类型:</td>
								<td><input type="text" name="TYPE" id="TYPE" value="${pd.TYPE}" maxlength="255" placeholder="这里输入外线类型" title="外线类型" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">端口号:</td>
								<td><input type="number" name="PORT" id="PORT" value="${pd.PORT}" maxlength="32" placeholder="这里输入端口号" title="端口号" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">外线呼叫超时时间:</td>
								<td><input type="number" name="TIMEOUT" id="TIMEOUT" value="${pd.TIMEOUT}" maxlength="32" placeholder="这里输入外线呼叫超时时间" title="外线呼叫超时时间" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">外线呼入类型:</td>
								<td><input type="text" name="INCOMING_TYPE" id="INCOMING_TYPE" value="${pd.INCOMING_TYPE}" maxlength="255" placeholder="这里输入外线呼入类型" title="外线呼入类型" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">外线呼入IVR:</td>
								<td><input type="text" name="INCOMING_IVR" id="INCOMING_IVR" value="${pd.INCOMING_IVR}" maxlength="255" placeholder="这里输入外线呼入IVR" title="外线呼入IVR" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">呼入分机:</td>
								<td><input type="number" name="INCOMING_EXTEN" id="INCOMING_EXTEN" value="${pd.INCOMING_EXTEN}" maxlength="32" placeholder="这里输入呼入分机" title="呼入分机" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">呼入队列:</td>
								<td><input type="text" name="INCOMING_CALLCENTER" id="INCOMING_CALLCENTER" value="${pd.INCOMING_CALLCENTER}" maxlength="255" placeholder="这里输入呼入队列" title="呼入队列" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">外线显示信息:</td>
								<td><input type="text" name="EFFECTIVE_CALLER_ID_NAME" id="EFFECTIVE_CALLER_ID_NAME" value="${pd.EFFECTIVE_CALLER_ID_NAME}" maxlength="255" placeholder="这里输入外线显示信息" title="外线显示信息" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">外线强制显示信息:</td>
								<td><input type="text" name="FORCE_EFFECTIVE_CALLER_ID_NAME" id="FORCE_EFFECTIVE_CALLER_ID_NAME" value="${pd.FORCE_EFFECTIVE_CALLER_ID_NAME}" maxlength="255" placeholder="这里输入外线强制显示信息" title="外线强制显示信息" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">黑名单类型:</td>
								<td><input type="text" name="TYPE_BLACKLIST" id="TYPE_BLACKLIST" value="${pd.TYPE_BLACKLIST}" maxlength="255" placeholder="这里输入黑名单类型" title="黑名单类型" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
								</td>
							</tr>
						</table>
						</div>
						<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
					</form>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->
</div>
<!-- /.main-container -->


	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript">
		$(top.hangge());
		//保存
		function save(){
			if($("#USERNAME").val()==""){
				$("#USERNAME").tips({
					side:3,
		            msg:'请输入外线号码',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#USERNAME").focus();
			return false;
			}
			if($("#REALM").val()==""){
				$("#REALM").tips({
					side:3,
		            msg:'请输入服务器地址',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#REALM").focus();
			return false;
			}
			if($("#PASSWORD").val()==""){
				$("#PASSWORD").tips({
					side:3,
		            msg:'请输入注册密码',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PASSWORD").focus();
			return false;
			}
			if($("#REGISTER").val()==""){
				$("#REGISTER").tips({
					side:3,
		            msg:'请输入是否注册',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#REGISTER").focus();
			return false;
			}
			if($("#TYPE").val()==""){
				$("#TYPE").tips({
					side:3,
		            msg:'请输入外线类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TYPE").focus();
			return false;
			}
			if($("#PORT").val()==""){
				$("#PORT").tips({
					side:3,
		            msg:'请输入端口号',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PORT").focus();
			return false;
			}
			if($("#TIMEOUT").val()==""){
				$("#TIMEOUT").tips({
					side:3,
		            msg:'请输入外线呼叫超时时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TIMEOUT").focus();
			return false;
			}
			if($("#INCOMING_TYPE").val()==""){
				$("#INCOMING_TYPE").tips({
					side:3,
		            msg:'请输入外线呼入类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#INCOMING_TYPE").focus();
			return false;
			}
			if($("#INCOMING_IVR").val()==""){
				$("#INCOMING_IVR").tips({
					side:3,
		            msg:'请输入外线呼入IVR',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#INCOMING_IVR").focus();
			return false;
			}
			if($("#INCOMING_EXTEN").val()==""){
				$("#INCOMING_EXTEN").tips({
					side:3,
		            msg:'请输入呼入分机',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#INCOMING_EXTEN").focus();
			return false;
			}
			if($("#INCOMING_CALLCENTER").val()==""){
				$("#INCOMING_CALLCENTER").tips({
					side:3,
		            msg:'请输入呼入队列',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#INCOMING_CALLCENTER").focus();
			return false;
			}
			if($("#EFFECTIVE_CALLER_ID_NAME").val()==""){
				$("#EFFECTIVE_CALLER_ID_NAME").tips({
					side:3,
		            msg:'请输入外线显示信息',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#EFFECTIVE_CALLER_ID_NAME").focus();
			return false;
			}
			if($("#FORCE_EFFECTIVE_CALLER_ID_NAME").val()==""){
				$("#FORCE_EFFECTIVE_CALLER_ID_NAME").tips({
					side:3,
		            msg:'请输入外线强制显示信息',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#FORCE_EFFECTIVE_CALLER_ID_NAME").focus();
			return false;
			}
			if($("#TYPE_BLACKLIST").val()==""){
				$("#TYPE_BLACKLIST").tips({
					side:3,
		            msg:'请输入黑名单类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TYPE_BLACKLIST").focus();
			return false;
			}
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
		</script>
</body>
</html>