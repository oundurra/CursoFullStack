function JobsController(opcion) {
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");
	var token = $("meta[name='_csrf']").attr("content");
	
	switch(opcion){
	case "listJob":
		$.ajax({
			type : "post",
		    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/jobs/list",
			success : function(res) {
				result="<table name='jobsTable' id='jobsTable' class='table-striped'><thead>"
				result+="<tr><th>Job ID</th><th>Job Title</th><th>Min.Salary</th><th>Max.Salary</th></tr>";
				result+="</thead><tbody>"
				$.each(res, function(k,v) {
					result+="<tr>";
					result+="<td>"+v.job_id+"</td>";
					result+="<td>"+v.job_title+"</td>";
					result+="<td>"+v.min_salary+"</td>";
					result+="<td>"+v.max_salary+"</td>";
					result+="</tr>";
				});
				result+="</tbody></table>";
				$("#modalTable").html(result);
				$("#jobsTable tr").click(function() {
				$("#job_id").val($(this).find("td:eq(0)").text());
				$("#job_title").val($(this).find("td:eq(1)").text());
				$("#min_salary").val($(this).find("td:eq(2)").text());
				$("#max_salary").val($(this).find("td:eq(3)").text());
				$("#myModal .close").click()
	        });
			$("#myModal").modal({show:true});
			
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda de trabajos.")
			}
		});       			
		break;
	case "getJob":
		$.ajax({
			type : "post",
		    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/jobs/get",
			data : "job_id="+$("#job_id").val(),
			success : function(res) {
				if (res == null || res == "") {
					$("#msg").show();
					$("#msg").html("No se encontraron registros.");
				} else {
					$("#job_id").val(res.job_id);
					$("#job_title").val(res.job_title);
					$("#min_salary").val(res.min_salary);
					$("#max_salary").val(res.max_salary);
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda.");
			}
		});       			
		break;
	case "insertJob":
		var jobJSON = 
			{
				'job_id': $("#job_id").val(),
				'job_title': $("#job_title").val(),
				'min_salary': $("#min_salary").val(),
				'max_salary': $("#max_salary").val()
			};
	
	    var postData = JSON.stringify(jobJSON);

	    $.ajax({
			type : "post",
		    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/jobs/insert",
			data : postData,
			contentType : "application/json; charset=utf-8",
	        dataType : "json",
			success : function(res) {
				if (res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro ingresado correctamente.");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo ingresar el registro.");
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("No se pudo ingresar el registro.");
			}
		});       	
	    break;
	case "updateJob":
		var jobJSON = 
			{
				'job_id': $("#job_id").val(),
				'job_title': $("#job_title").val(),
				'min_salary': $("#min_salary").val(),
				'max_salary': $("#max_salary").val()
			};

	    var postData = JSON.stringify(jobJSON);

		$.ajax({
			type : "post",
		    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/jobs/update",
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
	case "deleteJob":
		$.ajax({
			type : "post",
		    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/jobs/delete",
			data : "job_id="+$("#job_id").val(),
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

function cargaJobs() {
	//$("#jobs").append("<option>Job1</option>");
	var token = $("meta[name='_csrf']").attr("content");
	
		$.ajax({
			type : "post",
		    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
			url : "/jobs/list",
			success : function(res) {

				$.each(res, function(k,v) {
					$("#jobs").append("<option>" + v.job_id + "</option>");
					//result+="<td>"+v.job_title+"</td>";
				});
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en carga de jobs.")
			}
		});       			
}


function cargaEmployees() {
	//alert($("#jobs").val());
	var token = $("meta[name='_csrf']").attr("content");
	$("#employees").find("option").remove();
		
	$.ajax({
		type : "post",
	    headers: {"X-CSRF-TOKEN": token}, //send CSRF token in header
		url : "/employees/listbyjobid",
		data : "job_id="+$("#jobs").val(),
		success : function(res) {	
			console.log(res);
			$.each(res, function(k,v) {
				$("#employees").append("<option>" + v + "</option>");
				console.log(v.first_name);
			});
		},
		error : function() {
			$("#msg").show();
			$("#msg").html("Error en carga de employees.")
		}
	});   			
}
