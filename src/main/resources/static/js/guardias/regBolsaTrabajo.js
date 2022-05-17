var tabla;

//funcion al cargar la página
$(document).ready(function () {
    $("#id_div_geografica").select2();
    $("#id_centro_trabajo").select2();
    mostrarTabla();
});

//Validacion de campos vacios
$("#btnAgregarBolsaTrab").on("click", function (event) {
    // event.preventDefault();
    let rfc = document.getElementById('rfc').value.length;
    let nombre = document.getElementById('nombre').value;
    let apellidoPat = document.getElementById('apellidoPat').value;
    let apellidoMat = document.getElementById('apellidoMat').value;
    let id_div_geografica = document.getElementById('id_div_geografica').value;
    let id_centro_trabajo = document.getElementById('id_centro_trabajo').value;


    if (rfc == 0 || (rfc < 12 && rfc > 13)) {
        $('.toast-warning').toast('show');
        $('.toast-body').text("El RFC esta vacio");
        return false;
    }

    if (nombre == 0) {
        $('.toast-warning').toast('show');
        $('.toast-body').text("El nombre esta vacio");
        return false;
    }

    if (apellidoPat == 0) {
        $('.toast-warning').toast('show');
        $('.toast-body').text("El apellido paterno esta vacio");
        return false;
    }

    if (apellidoMat == 0) {
        $('.toast-warning').toast('show');
        $('.toast-body').text("El apellido materno esta vacio");
        return false;
    }

    if (id_div_geografica == 0 || $("#id_div_geografica").val() == 00) {
        $('.toast-warning').toast('show');
        $('.toast-body').text("No ha seleccionado ninguna división geográfica");
        return false;
    }

    if (id_centro_trabajo == 0) {
        $('.toast-warning').toast('show');
        $('.toast-body').text("No ha seleccionado ningun centro de trabajo");
        return false;
    }

});

function mostrarTabla() {
    $('#tbl_bolsaTrabajo').DataTable({
        pageLength: 3,
        lengthMenu: [[3, 10, 25, 50, -1], [3, 10, 25, 50, "All"]],
        sort: true,
        ajax: {
            url: '/rest_bolsaTrabajo/registros',
            dataSrc: ''
        },
        order: [
            [1, "desc"]
        ],

        dom: 'Bfrtip',
        buttons: [
            {
                extend: 'excel',
                title: 'Guardias personal externo',
                exportOptions: {
                    columns: [2, 3, 4, 5, 6, 7],
                },            

                className: 'btn btn-outline-success',
                excelStyles: {                // Add an excelStyles definition
                    template: "green_medium",  // Apply the 'blue_medium' template
                },
            },
            {
                extend: 'pdf',

                title: 'Guardias personal externo',
                orientation: 'landscape',
                pageSize: 'LETTER',
                customize: function (doc) {

                    doc.styles.title = {
                        color: '#a72c4d',
                        fontSize: '20',
                        alignment: 'center'
                    }
                    doc.styles.tableHeader = {
                        fillColor: '#a72c4d',
                        color: 'white',
                        fontSize: '12',
                        alignment: 'center'

                    }
                    doc.content[1].table.widths =
                        Array(doc.content[1].table.body[0].length + 1).join('*').split('');

                    var rowCount = doc.content[1].table.body.length;
                    for (i = 1; i < rowCount; i++) {
                        doc.content[1].table.body[i][0].alignment = 'center';
                        doc.content[1].table.body[i][1].alignment = 'center';
                        doc.content[1].table.body[i][2].alignment = 'center';
                        doc.content[1].table.body[i][3].alignment = 'center';
                      
                    }

                },

                exportOptions: {
                    columns: [2, 3, 4, 5, 6, 7],
                },
                pageStyle: {
                    horizontalCentered: true,
                    verticalCentered: true,
                },
                className: 'btn btn-outline-danger',
                excelStyles: {
                    template: "green_medium",
                },
            },
        ],
        columnDefs: [

            {
                targets: 0,
                data: "id",
                orderable: false,
                bSort: false,
                ordering: false,
                render:
                    function (data) {
                        return '<div class="btn-toolbar" id="eliminar" role="toolbar"><a href="/guardias/eliminar/' + data + '" class="btn btn-danger"><i class="fa fa-trash"></i></a>';
                        // return '<div class="btn-toolbar" id="eliminar" role="toolbar"><a class="btn btn-danger" onclick="return eliminar('+data+')"><i class="fa fa-trash"></i></a>';
                    }
            },
            {
                targets: 1,
                data: "id",
                orderable: false,
                bSort: false,
                ordering: false,
                render:
                    function (data) {
                        return '<div class="btn-toolbar" id="editar" role="toolbar"><a href="/guardias/editar/' + data + '" class="btn btn-warning"><i class="fa fa-edit"></i></a>';
                        // return '<div class="btn-toolbar" id="editar" role="toolbar"><a class="btn btn-warning" onclick="return editar('+data+')"><i class="fa fa-edit"></i></a>';
                    }

            },
            {
                targets: 2,
                data: "rfc"

            },
            {
                targets: 3,
                data: "nombre",
                searchable: false
            },
            {
                targets: 4,
                data: "apellidoPat",
                searchable: false
            },
            {
                targets: 5,
                data: "apellidoMat",
                searchable: false
            },
            {
                targets: 6,
                data: "n_Div_Geografica",
                // searchable: false
            },
            {
                targets: 7,
                data: "n_Centro_Trabajo",
                render:
                    function (data) {
                        return '<span class="badge badge-primary text-wrap issste">' + data + '</span>';
                    },

                // "searchable": false
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
            searchPlaceholder: "RFC"
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