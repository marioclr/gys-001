﻿// agregar guardia
var tabla;
var tipo = 'I';

if ($("#txtRFC").val().length > 0) {
    tipo = 'E';
    muestraPanelExterno();
}

$("#btnAgregarGuardia").on("click", function (event) {
    event.preventDefault();

    var oAdsc = $("#ddlAscripcion").val().split(';;;');
    var oPuesto = $("#ddlPuesto").val().split(';;;');

    var empleado, centro_trabajo, tipo_ct, clave_servicio, puesto, nivel, sub_nivel, tipo_jornada, horas, tipo_guardia, ini, fin;
    var zona, tabulador, riesgos, quincena, motivo, folio, movimiento, coment;

    var obj;
    if (tipo == 'I') {
        obj = JSON.stringify({ tipo_ct: $("#hdnTipoCT").val(), clave_servicio: $("#lblServicio").text(), puesto: $("#lblPuesto").text(), nivel: $("#hdnNivel").val(), sub_nivel: $("#hdnSubNivel").val(), tipo_jornada: $("#lblHoras").text(), tipo_guardia: tipo });
    } else {
        obj = JSON.stringify({ tipo_ct: oAdsc[1], clave_servicio: $("#ddlServicio").val(), puesto: oPuesto[0], nivel: $("#ddlNivel").val().substring(0, 2), sub_nivel: $("#ddlNivel").val().substring(2), tipo_jornada: $("#ddlJornada").val(), tipo_guardia: tipo });
    }
    console.log(obj);

    $.ajax({
        type: "POST",
        url: "RegistraGuardias.aspx/ValidaPuestoAutorizado",
        data: obj,
        contentType: 'application/json; charset=utf-8',
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
            return 0;
        },
        success: function (data) {
            //console.log(data.d);
            if (data.d > 0) {
                //alert("Las caracteristicas del puesto están autorizadas. No. de registro: " + data.d);

                //obtener los valores de los campos
                if (tipo == 'I') {
                    empleado = $("#txtNumero").val();
                    tipo_ct = $("#hdnTipoCT").val();
                    centro_trabajo = $("#lblAdscripcion").text();
                    clave_servicio = $("#lblServicio").text();
                    puesto = $("#lblPuesto").text();
                    nivel = $("#hdnNivel").val();
                    sub_nivel = $("#hdnSubNivel").val();
                    tipo_jornada = $("#lblHoras").text();
                    horas = $("#txtDias").val();
                    ini = moment($("#txtFechaInicio").val(), "DD/MM/YYYY").format("MM/DD/YYYY");
                    fin = moment($("#txtFechaFin").val(), "DD/MM/YYYY").format("MM/DD/YYYY");
                    tipo_guardia = tipo;
                    tabulador = $("#hdnTabulador").val();
                    zona = $("#hdnZona").val();
                    folio = $("#txtFolio").val();
                    motivo = $("#ddlMotivo option:selected").text();
                    movimiento = $("#ddlMovimiento option:selected").text();
                    riesgos = $("#ddlRiesgos option:selected").text();
                    quincena = $("#ddlQuincena option:selected").val();
                    usuario = $("#hdnUserName").val();
                    coment = $("#txtComentarios").val();
                }
                else {
                    empleado = $("#txtRFC").val();
                    tipo_ct = oAdsc[1];
                    centro_trabajo = oAdsc[0];
                    clave_servicio = $("#ddlServicio option:selected").val();
                    puesto = oPuesto[0];
                    nivel = $("#ddlNivel option:selected").val().substring(0, 2);
                    sub_nivel = $("#ddlNivel option:selected").val().substring(2);
                    tipo_jornada = $("#ddlJornada option:selected").val();
                    horas = $("#txtDias").val();
                    ini = moment($("#txtFechaInicio").val(), "DD/MM/YYYY").format("MM/DD/YYYY");
                    fin = moment($("#txtFechaFin").val(), "DD/MM/YYYY").format("MM/DD/YYYY");
                    tipo_guardia = tipo;
                    tabulador = oPuesto[1];
                    zona = oAdsc[2];
                    folio = $("#txtFolio").val();
                    motivo = $("#ddlMotivo option:selected").val();
                    movimiento = $("#ddlMovimiento option:selected").val();
                    riesgos = $("#ddlRiesgos option:selected").text();
                    quincena = $("#ddlQuincena option:selected").val();
                    usuario = $("#hdnUserName").val();
                    coment = $("#txtComentarios").val();
                }

                if (tipo_ct.length > 0 && clave_servicio.length > 0 && puesto.length > 0) {
                    var obj = JSON.stringify({
                        id: empleado, centro_trabajo: centro_trabajo, clave_servicio: clave_servicio, puesto: puesto, nivel: nivel, sub_nivel: sub_nivel, tipo_jornada: tipo_jornada, horas: horas, tipo_guardia: tipo_guardia, ini: ini, fin: fin,
                        tipo_tabulador: tabulador, zona: zona, riesgos: riesgos, userName: usuario, quincena: quincena,
                        folio: folio, motivo: motivo, movimiento: movimiento, coment: coment});
                    // llamada a ajax
                    // string folio, string motivo, string movimiento, string coment
                    $.ajax({
                        type: "POST",
                        url: "RegistraGuardias.aspx/AgregarGuardia",
                        data: obj,
                        contentType: 'application/json; charset=utf-8',
                        error: function (xhr, ajaxOptions, thrownError) {
                            console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
                        },
                        success: function (data) {
                            console.log("éxito", data.d);
                            $(document).Toasts('create', {
                                class: 'bg-warning',
                                title: 'NOTIFICACION',
                                subtitle: 'Guardia',
                                body: 'El registro de guardia fué agregado de manera correcta.'
                            });
                            // cerrar ventana modal usando jquery
                            //$("#AgregarHorario").modal('toggle');
                            //addRow(data.d);
                            carga_lista_guardias();
                        }
                    });

                } else {
                    if (parseInt(idmedico) < 1) {
                        alert("Ingrese la información del médico.");
                    } else {
                        alert("Ingrese los datos requeridos.");
                    }
                }
            } else {
                alert("Las caracteristicas del puesto no están autorizadas.");
                return;
            }
        }
    });


});

function carga_lista_guardias() {
    // obtener los datos del texto de dni
    var emp;
    if (tipo == 'I')
        emp = $("#txtNumero").val();
    else
        emp = $("#txtRFC").val();

    var obj = JSON.stringify({ id: emp, tipo_guardia: tipo });

    $.ajax({
        type: "POST",
        url: "RegistraGuardias.aspx/ListaGuardias",
        data: obj,
        contentType: 'application/json; charset=utf-8',
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
        },
        success: function (data) {
            //console.log("éxito", data);
            tabla.clear().draw();
            for (var i = 0; i < data.d.length; i++) {
                addRow(data.d[i]);
            }
        }
    });
}

function addRow(obj) {
    //var fechaIni = moment(obj.Inicio).format("dd/MM/yyyy");
    //var fechaFin = moment(obj.Fin).format("dd/MM/yyyy");

    tabla.row.add(
        [
            (obj.Estatus) ? '<button type="button" value="Modificar" id="btnModificar" class="btn btn-primary btn-sm" data-target="#ModificarGuardia" data-toggle="modal">Modificar</button>': '',
            '',
            obj.Empleado,
            obj.Puesto,
            moment(obj.Inicio).format('DD/MM/YYYY'),
            moment(obj.Quincena).format('DD/MM/YYYY'),
            obj.Horas,
            obj.Importe,
            obj.Ordinal
        ]
    ).draw();
}

function llenarDatosGuardias(obj) {
    $("#txtEmpleado").text(obj.Nombre);
    $("#lblAdscripcion").text(obj.Especialidad.Descripcion);
    $("#lblServicio").text(obj.IdMedico);
    $("#lblPuesto").text(obj.IdMedico);
    $("#lblHorario").text(obj.IdMedico);
    $("#txtNivel").text(obj.IdMedico);
    $("#txtSubNivel").text(obj.IdMedico);
}

function llenarDatosGuardiaDefault() {
    alert("No existe médico con documento " + $("#txtDni").val());
    $("#lblNombres").text("");
    $("#lblApellidos").text("");
    $("#lblEspecialidad").text("");
    $("#txtMedico").val("0");
    $("#txtDni").val("");
}

function editarDatosGuardia(obj) {
    $("#txtEditarFecha").val(obj[3]);
    $("#txtEditarHora").val(obj[4]);
    $("#txtIdHorarioAtencion").val(obj[2]);
}

function initDataTable() {

    tabla = $("#tbl_guardias").DataTable({
        "columnDefs":
            [{
                "targets": [0, 1],
                "orderable": false
            },
            {
                "targets": 1,
                data: null,
                "defaultContent": '<div id="info_guardia" class="btn-group btn-group-sm"><a href="#" class="btn btn-danger"><i class="fas fa-trash"></i></a></div >'
            },
            {
                "targets": 5,
                "orderable": true
            },
            {
                "targets": 8,
                visible: false
            }],
        "order":
            [
                [5, "desc"]
            ],
        "aoColumns": [
            null,
            null,
            null,
            null,
            null,
            { "sType": "date-uk" },
            null,
            null
            ]
    });
}

$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
    // here is the new selected tab id
    var selectedTabId = e.target.id;

    if (selectedTabId == 'hinterno') {
        tipo = 'I';
        //$("#hdnTipo").val("I");
    } else {
        tipo = 'E';
        //$("#hdnTipo").val("E");
    }
});

function muestraPanelExterno() {
    $(".nav-link#hexterno").addClass("active");
    $(".nav-link#hinterno").removeClass('active');
    $(".tab-pane#pexterno").addClass("active").siblings().removeClass('active');
}

function muestraPanelInterno() {
    $(".nav-link#hinterno").addClass("active");
    $(".nav-link#hexterno").removeClass('active');
    $(".tab-pane#pinterno").addClass("active").siblings().removeClass('active');
}

function estatusPresupuestal() {
    //alert("Cambio de Servicio. " + $("#ddlDivision").val());
    var obj = JSON.stringify({ Suficiencia:1, deleg: $("#hdnUserDeleg").val() });
    console.log(obj);

    $.ajax({
        url: "PresupuestoHandler.ashx?Suficiencia=1&deleg=" + $("#hdnUserDeleg").val(),
        contentType: 'application/json; charset=utf-8',
        responseType: "json",
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
        },
        success: function (data) {
            console.log("éxito", data);

        }
    });
}

$(document).ready(function () {

	alert( "JQuery ready. ");

    //initDataTable();
    //carga_lista_guardias();
    //estatusPresupuestal();
});

$("#ddlAscripcion").change(function () {
	var i = 0;
	alert( "Cambio de Ascripcion. " + $("#ddlAscripcion").val() );
    var oAdsc = $("#ddlAscripcion").val().split(';;;');
    //alert("Cambio de Adscripción. " + oAdsc[0] + " " + oAdsc[1] + " " + oAdsc[2]);
    var obj = JSON.stringify({ adsc: oAdsc[0] });
    console.log(obj);

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/rest_guardias/datos",
        contentType: 'application/json; charset=utf-8',
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
        },
        success: function (data) {
            for (i = 0; i < data.length; i++) {
            	console.log(data[i]);
            	//alert(i + ": " + data[i].nombre);
            }
        }
    });
});

$("#ddlPuesto").change(function () {
    var oAdsc = $("#ddlAscripcion").val().split(';;;');
    var oPuesto = $("#ddlPuesto").val().split(';;;');
    //alert("Cambio de Puesto. " + oPuesto[0] + ', ' + oPuesto[1]);
    var obj = JSON.stringify({ adsc: oAdsc[0], puesto: oPuesto[0] });
    console.log(obj);

    $.ajax({
        type: "POST",
        url: "RegistraGuardias.aspx/ListaServicios",
        data: obj,
        contentType: 'application/json; charset=utf-8',
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
        },
        success: function (data) {
            $("#ddlServicio option").remove();
            for (var i = 0; i < data.d.length; i++) {
                $("#ddlServicio").append('<option value="' + data.d[i].Clave + '">' + data.d[i].Clave + "-" + data.d[i].Descripcion + '</option>');
                //console.log(data.d[i].Clave + "-" + data.d[i].Descripcion);
            }
            if ($("#ddlServicio option").length > 0) {
                $("#ddlServicio").trigger('change');
            }
        }
    });
});

$("#ddlServicio").change(function () {
    //alert("Cambio de Servicio. " + $("#ddlServicio").val());
    var oAdsc = $("#ddlAscripcion").val().split(';;;');
    var oPuesto = $("#ddlPuesto").val().split(';;;');
    var obj = JSON.stringify({ adsc: oAdsc[0], puesto: oPuesto[0], servicio: $("#ddlServicio").val() });
    console.log(obj);

    $.ajax({
        type: "POST",
        url: "RegistraGuardias.aspx/ListaNivels",
        data: obj,
        contentType: 'application/json; charset=utf-8',
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
        },
        success: function (data) {
            $("#ddlNivel option").remove();
            for (var i = 0; i < data.d.length; i++) {
                $("#ddlNivel").append('<option value="' + data.d[i].Nivel + data.d[i].Sub_nivel + '">' + data.d[i].Nivel + "/" + data.d[i].Sub_nivel + '</option>');
                //console.log(data.d[i].Nivel + "-" + data.d[i].Sub_nivel);
            }
            if ($("#ddlNivel option").length > 0) {
                $("#ddlNivel").trigger('change');
            }
        }
    });
});

$("#ddlNivel").change(function () {
    //alert("Cambio de Nivel. " + $("#ddlNivel").val());
    var oAdsc = $("#ddlAscripcion").val().split(';;;');
    var oPuesto = $("#ddlPuesto").val().split(';;;');
    var obj = JSON.stringify({ adsc: oAdsc[0], puesto: oPuesto[0], servicio: $("#ddlServicio").val(), niveles: $("#ddlNivel").val() });
    console.log(obj);

    $.ajax({
        type: "POST",
        url: "RegistraGuardias.aspx/ListaJornadas",
        data: obj,
        contentType: 'application/json; charset=utf-8',
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
        },
        success: function (data) {
            $("#ddlJornada option").remove();
            for (var i = 0; i < data.d.length; i++) {
                $("#ddlJornada").append('<option value="' + data.d[i].Clave + '">' + data.d[i].Descripcion + '</option>');
                //console.log(data.d[i].Nivel + "-" + data.d[i].Sub_nivel);
            }
            if ($("#ddlJornada option").length > 0) {
                $("#ddlJornada").trigger('change');
            }
        }
    });
});

$("#btnValidaPuesto").on("click", function (event) {
    event.preventDefault();
    var oAdsc = $("#ddlAscripcion").val().split(';;;');
    var oPuesto = $("#ddlPuesto").val().split(';;;');

    var obj = JSON.stringify({ tipo_ct: oAdsc[1], clave_servicio: $("#ddlServicio").val(), puesto: oPuesto[0], nivel: $("#ddlNivel").val().substring(0, 2), sub_nivel: $("#ddlNivel").val().substring(2), tipo_jornada: $("#ddlJornada").val(), tipo_guardia: tipo });
    console.log(obj);
    $.ajax({
        type: "POST",
        url: "RegistraGuardias.aspx/ValidaPuestoAutorizado",
        data: obj,
        contentType: 'application/json; charset=utf-8',
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
            return 0;
        },
        success: function (data) {
            //console.log(data.d);
            if (data.d > 0) {
                alert("Las caracteristicas del puesto están autorizadas. No. de registro: " + data.d);
                return data.d;
            } else {
                alert("Las caracteristicas del puesto no están autorizadas.");
                return 0;
            }
        }
    });
    
});

// evento click para boton Modificar
$(document).on('click', '#btnModificar', function (e) {
    e.preventDefault();

    //var row = $(this).parent().parent()[0];
    var dataRow = tabla.row($(this).parents('tr')).data();
    llenarDatosGuardia(dataRow);
});

//$('#tbl_guardias tbody').on('click', 'tr', function () {
//    var d = tabla.row(this).data();

//    d.Horas++;

//    tabla
//        .row(this)
//        .data(d)
//        .draw();
//});

function llenarDatosGuardia(dataRow) {
    var fec_ini = dataRow[5];
    var obj = JSON.stringify({ id: dataRow[2], ini: dataRow[4], quincena: dataRow[5], ordinal: dataRow[8], tipo_guardia: tipo });
    console.log(obj);
    $.ajax({
        type: "POST",
        url: "RegistraGuardias.aspx/ObtenerExtraInfo",
        data: obj,
        contentType: 'application/json; charset=utf-8',
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
            return 0;
        },
        success: function (data) {
            //console.log(data.d);
            //$("#txtEditarFecha").val(data[3]);
            //$("#txtEditarHora").val(data[4]);
            $("#txtFolioModal").val(data.d.Folio);
            $("#ddlMovimientoModal").val(data.d.Movimiento);
            $("#ddlMotivoModal").val(data.d.Motivo);
            $("#ddlRiesgosModal").val(data.d.Riesgos);
            $("#txtDiasModal").val(data.d.Horas);
            $("#txtComentariosModal").val(data.d.Coment);
            $("#hdnIdModal").val(data.d.Empleado);
            $("#hdnIniModal").val(moment(data.d.Inicio).format('DD/MM/YYYY'));
            $("#hdnQuincenaModal").val(moment(data.d.Quincena).format('DD/MM/YYYY'));
            $("#hdnOrdinalModal").val(data.d.Ordinal);
        }
    });
}

// evento click para boton Actualizar
$(document).on('click', '#btnActualizar', function (e) {
    e.preventDefault();

    var obj = JSON.stringify({
        id: $("#hdnIdModal").val(), ini: $("#hdnIniModal").val(), quincena: $("#hdnQuincenaModal").val(),
        ordinal: $("#hdnOrdinalModal").val(), tipo_guardia: tipo, horas: $("#txtDiasModal").val(),
        riesgos: $("#ddlRiesgosModal").val(), userName: $("#hdnUserName").val(), folio: $("#txtFolioModal").val(),
        motivo: $("#ddlMotivoModal").val(), movimiento: $("#ddlMovimientoModal").val(), coment: $("#txtComentariosModal").val()
    });
    console.log(obj);

    $.ajax({
        type: "POST",
        url: "RegistraGuardias.aspx/ActualizaGuardia",
        data: obj,
        contentType: 'application/json; charset=utf-8',
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
            return 0;
        },
        success: function (data) {
            console.log("éxito", data.d);
            $(".modal-header .close").trigger('click');
            $(document).Toasts('create', {
                class: 'bg-warning',
                title: 'NOTIFICACION',
                subtitle: 'Guardia',
                body: 'El registro de guardia fué modificado de manera correcta.'
            });
            carga_lista_guardias();
        }
    });

});

// evento click para boton eliminar
$('#tbl_guardias tbody').on('click', 'div', function (e) {
    e.preventDefault();

    //var row = $(this).parent().parent()[0];
    //var dataRow = tabla.fnGetData(row);

    var dataRow = tabla.row($(this).parents('tr')).data();
    var obj = JSON.stringify({ id: dataRow[2], ini: dataRow[4], quincena: dataRow[5], ordinal: dataRow[8], tipo_guardia: tipo });
    console.log(obj);

    var response = confirm("¿Está seguro que desea eliminar el horario?");
    if (response) {
        $.ajax({
            type: "POST",
            url: "RegistraGuardias.aspx/EliminaGuardia",
            data: obj,
            dataType: "json",
            contentType: 'application/json; charset=utf-8',
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
            },
            success: function (response) {
                if (response.d) {
                    $(document).Toasts('create', {
                        class: 'bg-warning',
                        title: 'NOTIFICACION',
                        subtitle: 'Guardia',
                        body: 'El registro de guardia fué eliminado de manera correcta.'
                    });
                    //alert("Registro eliminado de manera correcta.");
                    carga_lista_guardias();
                } else {
                    alert("No se pudo eliminar el registro.");
                }
            }
        });
    }
});