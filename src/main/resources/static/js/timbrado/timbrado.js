
// $(document).ready(function () {
//     mostrarTabla();
//     alert("funcionando");
// });
// btnBuscarQnaTimbrado
var tabla;
$("#btnBuscarQnaTimbrado").on("click", function (event){
    let quincena= document.getElementById('quincena').value;

    if (quincena == null || $("#quincena").val()== 0 ){
        alert("No ha seleccionado ninguna quincena");

        return false;
    }

    // quincena = parseInt(quincena);

    var qna = { "quincena" : $("#quincena").val() };

    tabla = $('#tbl_timbrado').DataTable({
        bLengthChange: false,
        bDestroy: true,
        sort: true,
        ajax: {
            type: "POST",
            url: "/timbrado/registros?"+ $.param(qna),
            dataSrc:'',
            error: function (xhr, textStatus, errorThrown) {
                console.log(xhr.status + " \n" + xhr.responseText, "\n" + errorThrown, "\n"+textStatus);
                alert("Error al hacer la busqueda")
                return 0;
            },
        },
       
        order: [
            [0 , 1, "desc"]
        ],

        columnDefs: [
            {
                targets: 0,
                data: "fec_pago_proceso"

            },
            {
                targets: 1,
                data: "registros_meta4"

            },
            {
                targets: 2,
                data: "isr_Meta4",
                searchable: false
            },
            {
                targets: 3,
                data: "layout_Recibidos_sb",
                searchable: false
            },
            {
                targets:4,
                data:"recibos_No_Reportados"
            },
            {
                targets:5,
                data:"registros"
            },
            {
                targets:6,
                data:"isr"
            },
            {
                targets:7,
                data:"registros_no_timbrados"
            },
            {
                targets:8,
                data:"isr_no_timbrado"
            }
            
        ],

        language: {
            lengthMenu: "Mostrar _MENU_ resultados",
            info: "Mostrando registros de _START_ a _END_ de un total de _TOTAL_ registros",
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

});



// function mostrarTabla() {
//     $('#tbl_timbrado').DataTable({
//         bLengthChange: false,
//         pageLength: 10,
//         lengthMenu: [[ 5, 8, 10, -1], [ 5, 8, 10, "Todos"]],
//         sort: true,
//         ajax: {
//             url: '/timbrado/registros?'+$.param(quincena),
//             error: function (jqXHR, textStatus, errorThrown) {
//                 console.log(xhr.status + " \n" + xhr.responseText, "\n" + thrownError);
//                 return 0;
//             },
//         },
       
//         order: [
//             [0 , 1, "desc"]
//         ],

//         columnDefs: [
//             {
//                 targets: 0,
//                 data: "fec_pago_proceso"

//             },
//             {
//                 targets: 1,
//                 data: "registros_meta4"

//             },
//             {
//                 targets: 2,
//                 data: "isr_Meta4",
//                 searchable: false
//             },
//             {
//                 targets: 3,
//                 data: "layout_Recibidos_sb",
//                 searchable: false
//             },
//             {
//                 targets:4,
//                 data:"recibos_No_Reportados"
//             },
//             {
//                 targets:5,
//                 data:"registros"
//             },
//             {
//                 targets:6,
//                 data:"isr"
//             },
//             {
//                 targets:7,
//                 data:"registros_no_timbrados"
//             },
//             {
//                 targets:8,
//                 data:"isr_no_timbrado"
//             }
            
//         ],

//         language: {
//             lengthMenu: "Mostrar _MENU_ resultados",
//             info: "Mostrando registros de _START_ a _END_ de un total de _TOTAL_ registros",
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
