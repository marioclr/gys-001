var tabla;

//funcion al cargar la página
$(document).ready(function () {
    // alert("funcionando");
    mostrarTabla();
    // autocompletar();
});

$("#btnBuscarFasesFecha").on("click", function (event) {
    // event.preventDefault();
  
    let fechas_paga = document.getElementById('fechas_paga').value;
    // alert(fechas_paga);

    if (fechas_paga == 0 || $("#fechas_paga").val() == 00) {
        // $('.toast-warning').toast('show');
        // $('.toast-body').text("No ha seleccionado ninguna fecha de pago");
        alert("No ha seleccionado ninguna fecha de pago")
        return false;
    }

    var fecha_paga = { "fec_paga": $("#fechas_paga").val() };
    console.log(fecha_paga);

    $.ajax({
        type: "POST",
        url: "/rest_procesoNomina/buscarPorFecha?" + $.param(fecha_paga),
        // url: "/rest_procesoNomina/buscarPorFecha",
        // data: { fec_pago: $("#fechas_paga").val() },
        data: fecha_paga,
        contentType: 'application/json; charset=utf-8',
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
            return 0;
        },
        success: function (data) {
            if(data == ""){
                console.log("No se encontro informacion con esa fecha");
            }else{
                // initDataTable();
                console.log("éxito", data);
                // tabla.clear().draw();
                // for (var i = 0; i < data.length; i++) {
                //     addRow(data[i]);
                // }

            }
          
        }
    });

});

function addRow(obj) {

    tabla.row.add(
        [
            // (obj.estado == 'ACT') ? '<button type="button" value="Modificar" id="btnModificar" class="btn btn-primary btn-sm" data-target="#ModificarGuardia" data-toggle="modal">Modificar</button>' : '',
            // '',
            obj.fec_pago,
            obj.actividad,
            obj.fec_ini,
            obj.fec_fin,
            obj.validado
        ]
    ).draw();
}




function mostrarTabla() {
    $('#tbl_nomina').DataTable({
        // "procesing": true,
        // "columnDefs":
        //     [{
        //         "targets": 0,
        //         "orderable": true
        //     },
        //     {
        //         "targets": 1,
        //         "orderable": true
        //     },
        //     {
        //         "targets": 2,
        //         "orderable": false
        //     },
        //     {
        //         "targets": 3,
        //         "orderable": false
        //     },{
        //         "targets": 4,
        //         "orderable": false
        //     }],
        // "aoColumns": [
        //     { "sType": "date-uk" },
        //     null,
        //     { "sType": "date-uk" },
        //     { "sType": "date-uk" },
        //     null,
        // ],

        pageLength: 10,
        lengthMenu: [[ 5, 8, 10, -1], [ 5, 8, 10, "Todos"]],
        sort: true,
        ajax: {
            url: '/rest_procesoNomina/fases',
            dataSrc: ''
        },
        order: [
            [0 , 1, "desc"]
        ],

        columnDefs: [
            {
                targets: 0,
                data: "fec_Pago"

            },
            {
                targets: 1,
                data: "actividad"

            },
            {
                targets: 2,
                data: "fec_Ini",
                searchable: false
            },
            {
                targets: 3,
                data: "fec_Fin",
                searchable: false
            },
            {
                targets: 4,
                data: "validado",
                // searchable: true,
                render:
                function (data) {
                    if(data == false){
                        return '<span class="badge badge-danger text-wrap">No Validado</span>';
                    }else{
                        return '<span class="badge badge-success text-wrap">Validado</span>';
                    }
                }
            },
            {
                targets: 5,
                data: "fec_Pago",
                orderable: false,
                bSort: false,
                ordering: false,
                render:
                    function (data) {
                        return '<div class="btn-toolbar" id="editar" role="toolbar"><a href="/nomina/actValidacion/' + data + '" class="btn btn-warning"><i class="fa fa-edit"></i></a>';
                        // return '<div class="btn-toolbar" id="editar" role="toolbar"><a class="btn btn-warning" onclick="return editar('+data+')"><i class="fa fa-edit"></i></a>';
                    }

            },
            
        ],

        language: {
            lengthMenu: "Mostrar _MENU_ resultados",
            info: "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            zeroRecords: "No se encontraron resultados",
            sSearch: "Buscar: ",
            infoEmpty: "Mostrando registros del 0 al 0 de un total de 0 registros",
            infoFiltered: "(Filtrado de un total de _MAX_ registros)",
            sProccessing: "Procesando ...",
            oPaginate: {
                sFirst: "Primero",
                sLast: "Ultimo",
                sNext: " Siguiente",
                sPrevious: "Anterior"

            },
            searchPlaceholder: "Buscar"
        }
    });
}

// function eliminar(id) {

//     if (confirm("Seguro que quieres eliminar el siguiente pastel?")) {
//         window.location = ("/guardias/eliminar/" + id);
//         alert("Borrado el usuario con id: " + id);
//     }

// }

// function editar(id) {

//     if (confirm("Seguro que quieres editar el siguiente pastel?")) {
//         window.location = ("/guardias/editar/" + id);
//         // alert("Borrado el usuario con id: " + id);
//     }

// }