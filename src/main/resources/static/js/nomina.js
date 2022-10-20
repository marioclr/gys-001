
$("#btnGuardarFases").on("click", function (event) {
    let fecha_pago= document.getElementById('fec_pago').value;

    if (fec_pago == null || fec_pago == 0 ){
        alert("No ha seleccionado ninguna fecha de pago");

        return false;
    }
});
//funcion al cargar la página
// $(document).ready(function () {
    // alert("funcionando");
    // mostrarTabla();
    // autocompletar();
// });
var tabla;

$("#btnBuscarFasesFecha").on("click", function (event) {
  
    let fechas_paga = document.getElementById('fechas_paga').value;
    // alert(fechas_paga);

    if (fechas_paga == 0 || $("#fechas_paga").val() == 00) {
        // $('.toast-danger').toast('show');
        // $('.toast-body').text("No ha seleccionado ninguna fecha de pago");
        alert("No ha seleccionado ninguna fecha de pago")
        return false;
    }

    var fecha_paga = { "fec_paga": $("#fechas_paga").val() };
    console.log(fecha_paga);

    $.ajax({
        type: "POST",
        url: "/rest_procesoNomina/buscarPorFecha?" + $.param(fecha_paga),
 
        data: fecha_paga,
        contentType: 'application/json; charset=utf-8',
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
            return 0;
        },
        success: function (data) {
            if(data == ""){
                // console.log("No se encontro informacion con esa fecha");
                alert("No se encontro informacion con esa fecha");
                // tabla.clear().draw();
                // $('.toast-warning').toast('show');
                // $('.toast-body').text("No se encontro informacion con esa fecha");
                return 0;
            }else{

                console.log("éxito", data);
                tabla = $('#tbl_nomina').DataTable({
                    paging: false,
                    searching: false,
                    bDestroy: true,
                    ajax: {
                        type: "POST",
                        url: "/rest_procesoNomina/buscarPorFecha?" + $.param(fecha_paga),
                        dataSrc: ''
                    },
            
                    order: [
                        [0 , 1, "desc"]
                    ],
            
                    columnDefs: [
                        {
                            targets: 0,
                            data: "fec_Pago",
                            orderable: false
            
                        },
                        {
                            targets: 1,
                            data: "actividad",
                            orderable: false
            
                        },
                        {
                            targets: 2,
                            data: "fec_Ini",
                            searchable: false
                        },
                        {
                            targets: 3,
                            data: "fec_Fin",
                            searchable: false,
                            orderable: false
                        },
                        {
                            targets: 4,
                            data: "validado",
                            searchable: true,
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
                            data: "id",
                            orderable: false,
                            bSort: false,
                            ordering: false,
                            render:
                                function (data) {
                                    return '<div class="btn-toolbar" id="editar" role="toolbar"><a href="/nomina/actValidacion/' + data + '" class="btn btn-warning"><i class="fa fa-edit"></i></a>';
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
          
        }
    });

});


// function mostrarTabla() {
//     $('#tbl_nomina').DataTable({

//         pageLength: 10,
//         lengthMenu: [[ 5, 8, 10, -1], [ 5, 8, 10, "Todos"]],
//         sort: true,
//         ajax: {
//             url: '/rest_procesoNomina/fases',
//             dataSrc: ''
//         },
//         order: [
//             [0 , 1, "desc"]
//         ],

//         columnDefs: [
//             {
//                 targets: 0,
//                 data: "fec_Pago"

//             },
//             {
//                 targets: 1,
//                 data: "actividad"

//             },
//             {
//                 targets: 2,
//                 data: "fec_Ini",
//                 searchable: false
//             },
//             {
//                 targets: 3,
//                 data: "fec_Fin",
//                 searchable: false
//             },
//             {
//                 targets: 4,
//                 data: "validado",
//                 // searchable: true,
//                 render:
//                 function (data) {
//                     if(data == false){
//                         return '<span class="badge badge-danger text-wrap">No Validado</span>';
//                     }else{
//                         return '<span class="badge badge-success text-wrap">Validado</span>';
//                     }
//                 }
//             },
//             {
//                 targets: 5,
//                 data: "fec_Pago",
//                 orderable: false,
//                 bSort: false,
//                 ordering: false,
//                 render:
//                     function (data) {
//                         return '<div class="btn-toolbar" id="editar" role="toolbar"><a href="/nomina/actValidacion/' + data + '" class="btn btn-warning"><i class="fa fa-edit"></i></a>';
//                         // return '<div class="btn-toolbar" id="editar" role="toolbar"><a class="btn btn-warning" onclick="return editar('+data+')"><i class="fa fa-edit"></i></a>';
//                     }

//             },
            
//         ],

//         language: {
//             lengthMenu: "Mostrar _MENU_ resultados",
//             info: "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
//             zeroRecords: "No se encontraron resultados",
//             sSearch: "Buscar: ",
//             infoEmpty: "Mostrando registros del 0 al 0 de un total de 0 registros",
//             infoFiltered: "(Filtrado de un total de _MAX_ registros)",
//             sProccessing: "Procesando ...",
//             oPaginate: {
//                 sFirst: "Primero",
//                 sLast: "Ultimo",
//                 sNext: " Siguiente",
//                 sPrevious: "Anterior"

//             },
//             searchPlaceholder: "Buscar"
//         }
//     });
// }