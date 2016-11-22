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
						<input type="hidden" name="PRE_OUTLINE_NAME" id="OUTLINE_NAME" value="${pd.USERNAME}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
							    <td style="width:75px;text-align: right;padding-top: 13px;">外线类型:</td>
							    <td id="js">
									<select class="chosen-select form-control" name="TYPE" style="vertical-align:top;"  title="外线类型" style="width:98%;" >
									<option value="sip" <c:if test="${pd.TYPE == 'sip' }">selected</c:if>>sip外线</option>
									<option value="gateway" <c:if test="${pd.TYPE == 'gateway' }">selected</c:if>>网关外线</option>
									</select>
								</td>
							    
								<td style="width:75px;text-align: right;padding-top: 13px;">外线号码:</td>
								<td><input type="text" name="USERNAME" id="USERNAME" value="${pd.USERNAME}" maxlength="255" placeholder="这里输入外线号码" title="外线号码" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">注册地址:</td>
								<td><input type="text" name="REALM" id="REALM" value="${pd.REALM}" maxlength="255" placeholder="这里输入服务器地址" title="服务器地址" style="width:98%;"/></td>
								<td style="width:75px;text-align: right;padding-top: 13px;">注册密码:</td>
								<td><input type="text" name="PASSWORD" id="PASSWORD" value="${pd.PASSWORD}" maxlength="255" placeholder="这里输入注册密码" title="注册密码" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">是否注册:</td>
								<td id="js">
									<select class="chosen-select form-control" name="REGISTER" id="register_id" data-placeholder="是否注册" style="vertical-align:top;"  title="级别" style="width:98%;" >
									<option value="true">注册</option>
									<option value="false">不注册</option>
									</select>
								</td>
								<td style="width:75px;text-align: right;padding-top: 13px;">端口号:</td>
								<td><input type="text" name="PORT" id="PORT" value="${pd.PORT == ' ' ? '5060' : pd.PORT}" maxlength="32" placeholder="这里输入端口号" title="端口号" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">超时时间:</td>
								<td id="js">
									<select class="chosen-select form-control" name="TIMEOUT" style="vertical-align:top;"  title="超时时间" style="width:98%;" >
									<option value="60" <c:if test="${pd.TIMEOUT == '60' }">selected</c:if>>1min</option>
									<option value="30" <c:if test="${pd.TIMEOUT == '30' }">selected</c:if>>30s</option>
									<option value="120" <c:if test="${pd.TIMEOUT == '120' }">selected</c:if>>2min</option>
									<option value="180" <c:if test="${pd.TIMEOUT == '180' }">selected</c:if>>3min</option>
									<option value="360" <c:if test="${pd.TIMEOUT == '360' }">selected</c:if>>6min</option>
									</select>
								</td>
							    
								<td style="width:75px;text-align: right;padding-top: 13px;">呼入类型:</td>
								<td id="js">
									<select class="chosen-select form-control" name="INCOMING_TYPE" style="vertical-align:top;"  title="呼入类型" style="width:98%;" >
									<option value="" ></option>
									<option value="zongji" <c:if test="${pd.INCOMING_TYPE == 'zongji' }">selected</c:if>>总机</option>
									<option value="callcenter" <c:if test="${pd.INCOMING_TYPE == 'callcenter' }">selected</c:if>>队列</option>
									<option value="exten" <c:if test="${pd.INCOMING_TYPE == 'exten' }">selected</c:if>>分机</option>
									<option value="ivr" <c:if test="${pd.INCOMING_TYPE == 'ivr' }">selected</c:if>>IVR</option>
									<option value="dynamicIVR" <c:if test="${pd.INCOMING_TYPE == 'dynamicIVR' }">selected</c:if>>动态IVR</option>
									<option value="dialAssistant" <c:if test="${pd.INCOMING_TYPE == 'dialAssistant' }">selected</c:if>>代转呼叫</option>
									<option value="route" <c:if test="${pd.INCOMING_TYPE == 'route' }">selected</c:if>>专员路由</option>
									</select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">外线呼入IVR:</td>
								<td><input type="text" name="INCOMING_IVR" id="INCOMING_IVR" value="${pd.INCOMING_IVR}" maxlength="255" placeholder="这里输入外线呼入IVR" title="外线呼入IVR" style="width:98%;"/></td>
								<td style="width:75px;text-align: right;padding-top: 13px;">呼入分机:</td>
								<td><input type="number" name="INCOMING_EXTEN" id="INCOMING_EXTEN" value="${pd.INCOMING_EXTEN}" maxlength="32" placeholder="这里输入呼入分机" title="呼入分机" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">呼入队列:</td>
								<td><input type="text" name="INCOMING_CALLCENTER" id="INCOMING_CALLCENTER" value="${pd.INCOMING_CALLCENTER}" maxlength="255" placeholder="这里输入呼入队列" title="呼入队列" style="width:98%;"/></td>
								<td style="width:75px;text-align: right;padding-top: 13px;">外线显示号码:</td>
								<td><input type="text" name="EFFECTIVE_CALLER_ID_NAME" id="EFFECTIVE_CALLER_ID_NAME" value="${pd.EFFECTIVE_CALLER_ID_NAME}" maxlength="255" placeholder="这里输入外线显示信息" title="外线显示信息" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">强制显示号码:</td>
								<td><input type="text" name="FORCE_EFFECTIVE_CALLER_ID_NAME" id="FORCE_EFFECTIVE_CALLER_ID_NAME" value="${pd.FORCE_EFFECTIVE_CALLER_ID_NAME}" maxlength="255" placeholder="这里输入外线强制显示信息" title="外线强制显示信息" style="width:98%;"/></td>
								<td style="width:75px;text-align: right;padding-top: 13px;">黑名单类型:</td>
								<td id="js">
									<select class="chosen-select form-control" name="TYPE_BLACKLIST" style="vertical-align:top;"  title="呼入类型" style="width:98%;" >
									<option value="none" <c:if test="${pd.TYPE_BLACKLIST == 'none' }">selected</c:if>>关闭</option>
									<option value="global" <c:if test="${pd.TYPE_BLACKLIST == 'global' }">selected</c:if>>全局</option>
									<option value="custom" <c:if test="${pd.TYPE_BLACKLIST == 'custom' }">selected</c:if>>自定义</option>
									</select>
								</td>
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
		            msg:'请输入注册地址',
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