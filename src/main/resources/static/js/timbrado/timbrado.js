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
        // sort: true,
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
            [0 , "desc"]
        ],

        columnDefs: [
            {
                targets: 0,
                data: "fec_pago_proceso"

            },
            {
                targets: 1,
                data: "registros_meta4",
                render:
                    function (data) {
                        if(data){
                            return '<span class="badge badge-primary text-wrap">' + data + '</span>';
                        }
                    },

            },
            {
                targets: 2,
                data: "isr_Meta4",
                render:
                    function (data) {
                        if(data>0){
                            return '<span class="badge badge-primary text-wrap">' + new Intl.NumberFormat('es-MX').format(data) + '</span>';
                        }else{
                            return '<span></span>';
                        }
                    },
                searchable: false
            },
            {
                targets: 3,
                data: "layout_Recibidos_sb",
                searchable: false
            },
            {
                targets:4,
                data:"recibos_No_Reportados",
                render:
                    function (data) {
                        if(data!=0){
                            return '<h5><span class="badge badge-warning text-wrap">' + data + '</span></h5>';
                        }else{
                            return '<span>' + data + '</span>';
                        }
                    }
            },
            {
                targets:5,
                data:"registros",
                render:
                    function (data) {
                        if(data>0){
                            return '<span class="badge badge-success text-wrap">' + data + '</span>';
                        }
                    }
            },
            {
                targets:6,
                data:"isr",
                render:
                    function (data) {
                        if(data>0){
                            return '<span class="badge badge-success text-wrap">' + new Intl.NumberFormat('es-MX').format(data) + '</span>';
                        }else{
                            return '<span></span>';
                        }
                    }

            },
            {
                targets:7,
                data:"registros_no_timbrados",
                render:
                    function (data) {
                        if(data>0){
                            return '<h5><span class="badge badge-danger text-wrap">' + data + '</span><h5>';
                        }else{
                            return '<span></span>';
                        }
                    }
            },
            {
                targets:8,
                data:"isr_no_timbrado",
                render:
                    function (data) {
                        if(data>0){
                            return '<span class="badge badge-danger text-wrap">' + new Intl.NumberFormat('es-MX').format(data) + '</span>';
                        }else{
                            return '<span></span>';
                        }
                    }
                
            }
            
        ],

        language: {
            lengthMenu: "Mostrar _MENU_ resultados",
            info: "Mostrando registros de _START_ a _END_ de un total de _TOTAL_ registros",
            zeroRecords: "Buscando resultados",
            sSearch: "Buscar: ",
            infoEmpty: "",
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
