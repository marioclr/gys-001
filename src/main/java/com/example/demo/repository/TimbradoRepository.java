package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.IQnaTimbrado;
import com.example.demo.model.ITimbradoMeta4;
import com.example.demo.model.Timbrado;

public interface TimbradoRepository extends JpaRepository<Timbrado, Date>{


    @Query(value="SELECT *  \r\n" +
    "FROM ( \r\n" +
    "SELECT COUNT(*) registros_Meta4, a.fec_pago fec_pago_proceso, \r\n" +
    "SUM( \r\n" +
        "Case When a.c1 in ('53') Then Case When a.i1<0 Then 0 When a.i1 = '' Then 0 When a.i1 Is Null Then 0 Else a.i1 END Else 0 END +  \r\n"+
        "Case When a.c2 in ('53') Then Case When a.i2<0 Then 0 When a.i2 = '' Then 0 When a.i2 Is Null Then 0 Else a.i2 END Else 0 END +  \r\n"+
        "Case When a.c3 in ('53') Then Case When a.i3<0 Then 0 When a.i3 = '' Then 0 When a.i3 Is Null Then 0 Else a.i3 END Else 0 END +  \r\n"+
        "Case When a.c4 in ('53') Then Case When a.i4<0 Then 0 When a.i4 = '' Then 0 When a.i4 Is Null Then 0 Else a.i4 END Else 0 END +  \r\n"+
        "Case When a.c5 in ('53') Then Case When a.i5<0 Then 0 When a.i5 = '' Then 0 When a.i5 Is Null Then 0 Else a.i5 END Else 0 END +  \r\n"+
        "Case When a.c6 in ('53') Then Case When a.i6<0 Then 0 When a.i6 = '' Then 0 When a.i6 Is Null Then 0 Else a.i6 END Else 0 END +  \r\n"+
        "Case When a.c7 in ('53') Then Case When a.i7<0 Then 0 When a.i7 = '' Then 0 When a.i7 Is Null Then 0 Else a.i7 END Else 0 END +  \r\n"+
        "Case When a.c8 in ('53') Then Case When a.i8<0 Then 0 When a.i8 = '' Then 0 When a.i8 Is Null Then 0 Else a.i8 END Else 0 END +  \r\n"+
        "Case When a.c9 in ('53') Then Case When a.i9<0 Then 0 When a.i9 = '' Then 0 When a.i9 Is Null Then 0 Else a.i9 END Else 0 END +  \r\n"+
        "Case When a.c10 in ('53') Then Case When a.i10<0 Then 0 When a.i10 = '' Then 0 When a.i10 Is Null Then 0 Else a.i10 END Else 0 END +  \r\n"+
        "Case When a.c11 in ('53') Then Case When a.i11<0 Then 0 When a.i11 = '' Then 0 When a.i11 Is Null Then 0 Else a.i11 END Else 0 END +  \r\n"+
        "Case When a.c12 in ('53') Then Case When a.i12<0 Then 0 When a.i12 = '' Then 0 When a.i12 Is Null Then 0 Else a.i12 END Else 0 END +  \r\n"+
        "Case When a.c13 in ('53') Then Case When a.i13<0 Then 0 When a.i13 = '' Then 0 When a.i13 Is Null Then 0 Else a.i13 END Else 0 END +  \r\n"+
        "Case When a.c14 in ('53') Then Case When a.i14<0 Then 0 When a.i14 = '' Then 0 When a.i14 Is Null Then 0 Else a.i14 END Else 0 END +  \r\n"+
        "Case When a.c15 in ('53') Then Case When a.i15<0 Then 0 When a.i15 = '' Then 0 When a.i15 Is Null Then 0 Else a.i15 END Else 0 END +  \r\n"+
        "Case When a.c16 in ('53') Then Case When a.i16<0 Then 0 When a.i16 = '' Then 0 When a.i16 Is Null Then 0 Else a.i16 END Else 0 END +  \r\n"+
        "Case When a.c17 in ('53') Then Case When a.i17<0 Then 0 When a.i17 = '' Then 0 When a.i17 Is Null Then 0 Else a.i17 END Else 0 END +  \r\n"+
        "Case When a.c18 in ('53') Then Case When a.i18<0 Then 0 When a.i18 = '' Then 0 When a.i18 Is Null Then 0 Else a.i18 END Else 0 END +  \r\n"+
        "Case When a.c19 in ('53') Then Case When a.i19<0 Then 0 When a.i19 = '' Then 0 When a.i19 Is Null Then 0 Else a.i19 END Else 0 END +  \r\n"+
        "Case When a.c20 in ('53') Then Case When a.i20<0 Then 0 When a.i20 = '' Then 0 When a.i20 Is Null Then 0 Else a.i20 END Else 0 END +  \r\n"+
        "Case When a.c21 in ('53') Then Case When a.i21<0 Then 0 When a.i21 = '' Then 0 When a.i21 Is Null Then 0 Else a.i21 END Else 0 END +  \r\n"+
        "Case When a.c22 in ('53') Then Case When a.i22<0 Then 0 When a.i22 = '' Then 0 When a.i22 Is Null Then 0 Else a.i22 END Else 0 END +  \r\n"+
        "Case When a.c23 in ('53') Then Case When a.i23<0 Then 0 When a.i23 = '' Then 0 When a.i23 Is Null Then 0 Else a.i23 END Else 0 END +  \r\n"+
        "Case When a.c24 in ('53') Then Case When a.i24<0 Then 0 When a.i24 = '' Then 0 When a.i24 Is Null Then 0 Else a.i24 END Else 0 END +  \r\n"+
        "Case When a.c25 in ('53') Then Case When a.i25<0 Then 0 When a.i25 = '' Then 0 When a.i25 Is Null Then 0 Else a.i25 END Else 0 END +  \r\n"+
        "Case When a.c26 in ('53') Then Case When a.i26<0 Then 0 When a.i26 = '' Then 0 When a.i26 Is Null Then 0 Else a.i26 END Else 0 END +  \r\n"+
        "Case When a.c27 in ('53') Then Case When a.i27<0 Then 0 When a.i27 = '' Then 0 When a.i27 Is Null Then 0 Else a.i27 END Else 0 END +  \r\n"+
        "Case When a.c28 in ('53') Then Case When a.i28<0 Then 0 When a.i28 = '' Then 0 When a.i28 Is Null Then 0 Else a.i28 END Else 0 END +  \r\n"+
        "Case When a.c29 in ('53') Then Case When a.i29<0 Then 0 When a.i29 = '' Then 0 When a.i29 Is Null Then 0 Else a.i29 END Else 0 END +  \r\n"+
        "Case When a.c30 in ('53') Then Case When a.i30<0 Then 0 When a.i30 = '' Then 0 When a.i30 Is Null Then 0 Else a.i30 END Else 0 END +  \r\n"+
        "Case When a.c31 in ('53') Then Case When a.i31<0 Then 0 When a.i31 = '' Then 0 When a.i31 Is Null Then 0 Else a.i31 END Else 0 END +  \r\n"+
        "Case When a.c32 in ('53') Then Case When a.i32<0 Then 0 When a.i32 = '' Then 0 When a.i32 Is Null Then 0 Else a.i32 END Else 0 END +  \r\n"+
        "Case When a.c33 in ('53') Then Case When a.i33<0 Then 0 When a.i33 = '' Then 0 When a.i33 Is Null Then 0 Else a.i33 END Else 0 END +  \r\n"+
        "Case When a.c34 in ('53') Then Case When a.i34<0 Then 0 When a.i34 = '' Then 0 When a.i34 Is Null Then 0 Else a.i34 END Else 0 END +  \r\n"+
        "Case When a.c35 in ('53') Then Case When a.i35<0 Then 0 When a.i35 = '' Then 0 When a.i35 Is Null Then 0 Else a.i35 END Else 0 END +  \r\n"+
        "Case When a.c36 in ('53') Then Case When a.i36<0 Then 0 When a.i36 = '' Then 0 When a.i36 Is Null Then 0 Else a.i36 END Else 0 END +  \r\n"+
        "Case When a.c37 in ('53') Then Case When a.i37<0 Then 0 When a.i37 = '' Then 0 When a.i37 Is Null Then 0 Else a.i37 END Else 0 END +  \r\n"+
        "Case When a.c38 in ('53') Then Case When a.i38<0 Then 0 When a.i38 = '' Then 0 When a.i38 Is Null Then 0 Else a.i38 END Else 0 END +  \r\n"+
        "Case When a.c39 in ('53') Then Case When a.i39<0 Then 0 When a.i39 = '' Then 0 When a.i39 Is Null Then 0 Else a.i39 END Else 0 END +  \r\n"+
        "Case When a.c40 in ('53') Then Case When a.i40<0 Then 0 When a.i40 = '' Then 0 When a.i40 Is Null Then 0 Else a.i40 END Else 0 END ) IsR_meta4,  \r\n"+
    "b.isr ISR_registrado_SB, b.registros layout_Recibidos_SB,(count(*) - b.registros) recibos_no_reportados \r\n" +
    "FROM cosif_prueba2 a, fechas_timbrado_nomina b \r\n" +
    "WHERE a.anio='2022' \r\n" +
        "AND a.quincena= ?1 \r\n" +
        "AND a.tipo in ('0','1') \r\n" +
        "AND a.id_empresa='01' \r\n" +
        "AND a.fec_pago = b.fec_pago \r\n" +
        "AND a.quincena = b.quincena \r\n" +
        "AND a.anio = b.anio \r\n" +
        "group by 2,4,5 \r\n" +
        "order by a.fec_pago \r\n" +
    ") A LEFT OUTER JOIN ( \r\n" +
    "SELECT a.fec_pago fec_pago_timbrado, count(*) registros, SUM(T1.ImpRete) Isr \r\n" +
    "FROM cosif_prueba2 a \r\n" +
    "INNER JOIN timbrado_nomina_2022 T1 ON a.rfc=T1.ID_EMPLEADO AND a.fec_pago=T1.FECHAPAGO \r\n" +
    "WHERE a.quincena = ?1 \r\n" +
        "AND a.anio = '2022' \r\n" +
        "AND a.tipo in ('0','1') \r\n" +
        "AND a.id_empresa='01' \r\n" +
        "AND (T1.ESTATUS IS NULL OR T1.ESTATUS='Cancelado') \r\n" +
        "GROUP BY 1 \r\n" +
        "ORDER BY a.fec_pago \r\n" +
    ") B \r\n" +
    "ON A.fec_pago_proceso=B.fec_pago_timbrado \r\n" +
    "LEFT OUTER JOIN ( \r\n" +
    "SELECT a.fec_pago fec_pago_cruce, COUNT(*) registros_no_timbrados, \r\n" +
    "SUM( \r\n" +
        "Case When a.c1 in ('53') Then Case When a.i1<0 Then 0 When a.i1 = '' Then 0 When a.i1 Is Null Then 0 Else a.i1 END Else 0 END +  \r\n"+
        "Case When a.c2 in ('53') Then Case When a.i2<0 Then 0 When a.i2 = '' Then 0 When a.i2 Is Null Then 0 Else a.i2 END Else 0 END +  \r\n"+
        "Case When a.c3 in ('53') Then Case When a.i3<0 Then 0 When a.i3 = '' Then 0 When a.i3 Is Null Then 0 Else a.i3 END Else 0 END +  \r\n"+
        "Case When a.c4 in ('53') Then Case When a.i4<0 Then 0 When a.i4 = '' Then 0 When a.i4 Is Null Then 0 Else a.i4 END Else 0 END +  \r\n"+
        "Case When a.c5 in ('53') Then Case When a.i5<0 Then 0 When a.i5 = '' Then 0 When a.i5 Is Null Then 0 Else a.i5 END Else 0 END +  \r\n"+
        "Case When a.c6 in ('53') Then Case When a.i6<0 Then 0 When a.i6 = '' Then 0 When a.i6 Is Null Then 0 Else a.i6 END Else 0 END +  \r\n"+
        "Case When a.c7 in ('53') Then Case When a.i7<0 Then 0 When a.i7 = '' Then 0 When a.i7 Is Null Then 0 Else a.i7 END Else 0 END +  \r\n"+
        "Case When a.c8 in ('53') Then Case When a.i8<0 Then 0 When a.i8 = '' Then 0 When a.i8 Is Null Then 0 Else a.i8 END Else 0 END +  \r\n"+
        "Case When a.c9 in ('53') Then Case When a.i9<0 Then 0 When a.i9 = '' Then 0 When a.i9 Is Null Then 0 Else a.i9 END Else 0 END +  \r\n"+
        "Case When a.c10 in ('53') Then Case When a.i10<0 Then 0 When a.i10 = '' Then 0 When a.i10 Is Null Then 0 Else a.i10 END Else 0 END +  \r\n"+
        "Case When a.c11 in ('53') Then Case When a.i11<0 Then 0 When a.i11 = '' Then 0 When a.i11 Is Null Then 0 Else a.i11 END Else 0 END +  \r\n"+
        "Case When a.c12 in ('53') Then Case When a.i12<0 Then 0 When a.i12 = '' Then 0 When a.i12 Is Null Then 0 Else a.i12 END Else 0 END +  \r\n"+
        "Case When a.c13 in ('53') Then Case When a.i13<0 Then 0 When a.i13 = '' Then 0 When a.i13 Is Null Then 0 Else a.i13 END Else 0 END +  \r\n"+
        "Case When a.c14 in ('53') Then Case When a.i14<0 Then 0 When a.i14 = '' Then 0 When a.i14 Is Null Then 0 Else a.i14 END Else 0 END +  \r\n"+
        "Case When a.c15 in ('53') Then Case When a.i15<0 Then 0 When a.i15 = '' Then 0 When a.i15 Is Null Then 0 Else a.i15 END Else 0 END +  \r\n"+
        "Case When a.c16 in ('53') Then Case When a.i16<0 Then 0 When a.i16 = '' Then 0 When a.i16 Is Null Then 0 Else a.i16 END Else 0 END +  \r\n"+
        "Case When a.c17 in ('53') Then Case When a.i17<0 Then 0 When a.i17 = '' Then 0 When a.i17 Is Null Then 0 Else a.i17 END Else 0 END +  \r\n"+
        "Case When a.c18 in ('53') Then Case When a.i18<0 Then 0 When a.i18 = '' Then 0 When a.i18 Is Null Then 0 Else a.i18 END Else 0 END +  \r\n"+
        "Case When a.c19 in ('53') Then Case When a.i19<0 Then 0 When a.i19 = '' Then 0 When a.i19 Is Null Then 0 Else a.i19 END Else 0 END +  \r\n"+
        "Case When a.c20 in ('53') Then Case When a.i20<0 Then 0 When a.i20 = '' Then 0 When a.i20 Is Null Then 0 Else a.i20 END Else 0 END +  \r\n"+
        "Case When a.c21 in ('53') Then Case When a.i21<0 Then 0 When a.i21 = '' Then 0 When a.i21 Is Null Then 0 Else a.i21 END Else 0 END +  \r\n"+
        "Case When a.c22 in ('53') Then Case When a.i22<0 Then 0 When a.i22 = '' Then 0 When a.i22 Is Null Then 0 Else a.i22 END Else 0 END +  \r\n"+
        "Case When a.c23 in ('53') Then Case When a.i23<0 Then 0 When a.i23 = '' Then 0 When a.i23 Is Null Then 0 Else a.i23 END Else 0 END +  \r\n"+
        "Case When a.c24 in ('53') Then Case When a.i24<0 Then 0 When a.i24 = '' Then 0 When a.i24 Is Null Then 0 Else a.i24 END Else 0 END +  \r\n"+
        "Case When a.c25 in ('53') Then Case When a.i25<0 Then 0 When a.i25 = '' Then 0 When a.i25 Is Null Then 0 Else a.i25 END Else 0 END +  \r\n"+
        "Case When a.c26 in ('53') Then Case When a.i26<0 Then 0 When a.i26 = '' Then 0 When a.i26 Is Null Then 0 Else a.i26 END Else 0 END +  \r\n"+
        "Case When a.c27 in ('53') Then Case When a.i27<0 Then 0 When a.i27 = '' Then 0 When a.i27 Is Null Then 0 Else a.i27 END Else 0 END +  \r\n"+
        "Case When a.c28 in ('53') Then Case When a.i28<0 Then 0 When a.i28 = '' Then 0 When a.i28 Is Null Then 0 Else a.i28 END Else 0 END +  \r\n"+
        "Case When a.c29 in ('53') Then Case When a.i29<0 Then 0 When a.i29 = '' Then 0 When a.i29 Is Null Then 0 Else a.i29 END Else 0 END +  \r\n"+
        "Case When a.c30 in ('53') Then Case When a.i30<0 Then 0 When a.i30 = '' Then 0 When a.i30 Is Null Then 0 Else a.i30 END Else 0 END +  \r\n"+
        "Case When a.c31 in ('53') Then Case When a.i31<0 Then 0 When a.i31 = '' Then 0 When a.i31 Is Null Then 0 Else a.i31 END Else 0 END +  \r\n"+
        "Case When a.c32 in ('53') Then Case When a.i32<0 Then 0 When a.i32 = '' Then 0 When a.i32 Is Null Then 0 Else a.i32 END Else 0 END +  \r\n"+
        "Case When a.c33 in ('53') Then Case When a.i33<0 Then 0 When a.i33 = '' Then 0 When a.i33 Is Null Then 0 Else a.i33 END Else 0 END +  \r\n"+
        "Case When a.c34 in ('53') Then Case When a.i34<0 Then 0 When a.i34 = '' Then 0 When a.i34 Is Null Then 0 Else a.i34 END Else 0 END +  \r\n"+
        "Case When a.c35 in ('53') Then Case When a.i35<0 Then 0 When a.i35 = '' Then 0 When a.i35 Is Null Then 0 Else a.i35 END Else 0 END +  \r\n"+
        "Case When a.c36 in ('53') Then Case When a.i36<0 Then 0 When a.i36 = '' Then 0 When a.i36 Is Null Then 0 Else a.i36 END Else 0 END +  \r\n"+
        "Case When a.c37 in ('53') Then Case When a.i37<0 Then 0 When a.i37 = '' Then 0 When a.i37 Is Null Then 0 Else a.i37 END Else 0 END +  \r\n"+
        "Case When a.c38 in ('53') Then Case When a.i38<0 Then 0 When a.i38 = '' Then 0 When a.i38 Is Null Then 0 Else a.i38 END Else 0 END +  \r\n"+
        "Case When a.c39 in ('53') Then Case When a.i39<0 Then 0 When a.i39 = '' Then 0 When a.i39 Is Null Then 0 Else a.i39 END Else 0 END +  \r\n"+
        "Case When a.c40 in ('53') Then Case When a.i40<0 Then 0 When a.i40 = '' Then 0 When a.i40 Is Null Then 0 Else a.i40 END Else 0 END ) Isr_no_timbrado \r\n"+
    "FROM cosif_prueba2 a \r\n" +
    "left outer join timbrado_nomina_2022 T1 \r\n" +
    "ON a.rfc=T1.id_Empleado \r\n" +
    "AND a.fec_pago=t1.fechapago \r\n" +
    "WHERE a.quincena = ?1 \r\n" +
        "AND a.anio = '2022' \r\n" +
        "AND a.tipo in ('0','1') \r\n" +
        "AND a.id_empresa='01' \r\n" +
        "AND T1.UUID IS NULL \r\n" +
        "GROUP BY 1 \r\n" +
        "ORDER BY a.fec_pago \r\n" +
    ") C \r\n" +
    "ON B.fec_pago_timbrado=C.fec_pago_cruce", nativeQuery = true) 
      List<ITimbradoMeta4> mostrarRegistrosMeta4(Integer quincena);

  @Query(value="Select distinct(quincena) qna From fechas_timbrado_nomina", nativeQuery = true)
  List<IQnaTimbrado> listaQnaTimbrado();
  

// Query para hacer la primera parte de la consulta en los registros de meta
//     select count(*) conteo,a.fec_pago,b.isr, b.registros,(count(*) - b.registros) diferencia from cosif_prueba2 a, fechas_timbrado_nomina b
// where a.anio='2022' and a.quincena='18' and a.tipo in ('0','1') and a.id_empresa='01' and a.fec_pago=b.fec_pago group by 2,3,4 order by fec_pago;
}
