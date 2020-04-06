function EmployeesController(opcion) {
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");
	var token = $("meta[name='_csrf']").attr("content");
	
	switch(opcion){
	case "list":
		$.ajax({
			type : "post",
		    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/employees/list",
			success : function(res) {
				$('#employeesTable').bootstrapTable('load', res);
				$('#employeesTable tbody').on('click', 'tr', function () {
					$("#employee_id").val($(this).find("td:eq(0)").text());
					$("#first_name").val($(this).find("td:eq(1)").text());
					$("#last_name").val($(this).find("td:eq(2)").text());
					$("#email").val($(this).find("td:eq(3)").text());
					$("#phone_number").val($(this).find("td:eq(4)").text());
					$("#hire_date").val($(this).find("td:eq(5)").text());
					$("#job_id").val($(this).find("td:eq(6)").text());
					$("#salary").val($(this).find("td:eq(7)").text());
					$("#commission_pct").val($(this).find("td:eq(8)").text());
					$("#manager_id").val($(this).find("td:eq(9)").text());
					$("#department_id").val($(this).find("td:eq(10)").text());
					$("#myModal .close").click();
				});
				$("#myModal").modal({show:true});
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda de empleados.")
			}
		});       			
		break;
	case "get":
		$.ajax({
			type : "post",
		    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/employees/get",
			data : "employee_id="+$("#employee_id").val(),
			success : function(res) {
				if (res == null || res == "") {
					$("#msg").show();
					$("#msg").html("No se encontraron registros.");
				} else {	
					$("#employee_id").val(res.employee_id);
					$("#first_name").val(res.first_name);
					$("#last_name").val(res.last_name);
					$("#email").val(res.email);
					$("#phone_number").val(res.phone_number);
					$("#hire_date").val(res.hire_date);
					$("#job_id").val(res.job_id);
					$("#salary").val(res.salary);
					$("#commission_pct").val(res.commission_pct);
					$("#manager_id").val(res.manager_id);
					$("#department_id").val(res.department_id);
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda.");
			}
		});       			
		break;
	case "insert":
		$("#employee_id").val(0),
		$("#first_name").val(""),
		$("#last_name").val(""),
		$("#email").val(""),
		$("#phone_number").val(""),
		$("#hire_date").val(new Date()),
		$("#job_id").val(""),
		$("#salary").val(0),
		$("#commission_pct").val(0),
		$("#manager_id").val(0),
		$("#departent_id").val(0)	
	    break;
	case "update":
		var json = 
			{
				'employee_id': $("#employee_id").val(),
				'first_name': $("#first_name").val(),
				'last_name': $("#last_name").val(),
				'email': $("#email").val(),
				'phone_number': $("#phone_number").val(),
				'hire_date': $("#hire_date").val(),
				'job_id': $("#job_id").val(),
				'salary': ( $("#salary").val() ? $("#salary").val() : "0"),
				'commission_pct': ( $("#commission_pct").val() ? $("#commission_pct").val() : "0"),
				'manager_id': $("#manager_id").val(),
				'deparment_id': $("#departent_id").val()
			};

		var postData = JSON.stringify(json);

		$.ajax({
			type : "post",
		    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/employees/update",
			data : postData,
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro modificado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo modificar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo modificar el registro.");
			}
		});       	
    break;
	case "delete":
		$.ajax({
			type : "post",
		    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/employees/delete",
			data : "employee_id="+$("#employee_id").val(),
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro eliminado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo eliminar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo eliminar el registro.");
			}
		});
		break;
	default:
		$("#msg").show();
		$("#msg").html("Opción incorrecta.");
	}
}
