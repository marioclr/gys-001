package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.ITimbradoMeta4;
import com.example.demo.model.Timbrado;

public interface TimbradoRepository extends JpaRepository<Timbrado, Date>{


    @Query(value="SELECT *  \r\n" +
    "FROM ( \r\n" +
    "SELECT COUNT(*) registros_Meta4, a.fec_pago fec_pago_proceso, \r\n" +
    "SUM(CASE WHEN a.c1 in ('53') THEN a.i1 ELSE 0 END + \r\n" +
    "CASE WHEN a.c2 in ('53') THEN  a.i2 ELSE 0 END + CASE WHEN  a.c3 in ('53') THEN  a.i3 ELSE 0 END + CASE WHEN a.c4 in ('53') THEN  a.i4 ELSE 0 END + \r\n" +
    "CASE WHEN a.c5 in ('53') THEN  a.i5 ELSE 0 END + CASE WHEN  a.c6 in ('53') THEN  a.i6 ELSE 0 END + CASE WHEN a.c7 in ('53') THEN  a.i7 ELSE 0 END + \r\n" +
    "CASE WHEN a.c8 in ('53') THEN  a.i8 ELSE 0 END + CASE WHEN  a.c9 in ('53') THEN  a.i9 ELSE 0 END + CASE WHEN a.c10 in ('53') THEN a.i10 ELSE 0 END + \r\n" +
    "CASE WHEN a.c11 in ('53') THEN a.i11 ELSE 0 END + CASE WHEN a.c12 in ('53') THEN a.i12 ELSE 0 END + CASE WHEN a.c13 in ('53') THEN a.i13 ELSE 0 END + \r\n" +
    "CASE WHEN a.c14 in ('53') THEN a.i14 ELSE 0 END + CASE WHEN a.c15 in ('53') THEN a.i15 ELSE 0 END + CASE WHEN a.c16 in ('53') THEN a.i16 ELSE 0 END + \r\n" +
    "CASE WHEN a.c17 in ('53') THEN a.i17 ELSE 0 END + CASE WHEN a.c18 in ('53') THEN a.i18 ELSE 0 END + CASE WHEN a.c19 in ('53') THEN a.i19 ELSE 0 END + \r\n" +
    "CASE WHEN a.c20 in ('53') THEN a.i20 ELSE 0 END + CASE WHEN a.c21 in ('53') THEN a.i21 ELSE 0 END + CASE WHEN a.c22 in ('53') THEN a.i22 ELSE 0 END + \r\n" +
    "CASE WHEN a.c23 in ('53') THEN a.i23 ELSE 0 END + CASE WHEN a.c24 in ('53') THEN a.i24 ELSE 0 END + CASE WHEN a.c25 in ('53') THEN a.i25 ELSE 0 END + \r\n" +
    "CASE WHEN a.c26 in ('53') THEN a.i26 ELSE 0 END + CASE WHEN a.c27 in ('53') THEN a.i27 ELSE 0 END + CASE WHEN a.c28 in ('53') THEN a.i28 ELSE 0 END + \r\n" +
    "CASE WHEN a.c29 in ('53') THEN a.i29 ELSE 0 END + CASE WHEN a.c30 in ('53') THEN a.i30 ELSE 0 END + CASE WHEN a.c31 in ('53') THEN a.i31 ELSE 0 END + \r\n" +
    "CASE WHEN a.c32 in ('53') THEN a.i32 ELSE 0 END + CASE WHEN a.c33 in ('53') THEN a.i33 ELSE 0 END + CASE WHEN a.c34 in ('53') THEN a.i34 ELSE 0 END + \r\n" +
    "CASE WHEN a.c35 in ('53') THEN a.i35 ELSE 0 END + CASE WHEN a.c36 in ('53') THEN a.i36 ELSE 0 END + CASE WHEN a.c37 in ('53') THEN a.i37 ELSE 0 END + \r\n" +
    "CASE WHEN a.c38 in ('53') THEN a.i38 ELSE 0 END + CASE WHEN a.c39 in ('53') THEN a.i39 ELSE 0 END + CASE WHEN a.c40 in ('53') THEN a.i40 ELSE 0 END) + \r\n" +
    "SUM(CASE WHEN a.c1 in ('46') THEN a.i1 ELSE 0 END + \r\n" +
    "CASE WHEN  a.c2 in ('46') THEN a.i2 ELSE 0 END + CASE WHEN  a.c3 in ('46') THEN  a.i3 ELSE 0 END + CASE WHEN  a.c4 in ('46') THEN  a.i4 ELSE 0 END + \r\n" +
    "CASE WHEN  a.c5 in ('46') THEN a.i5 ELSE 0 END + CASE WHEN  a.c6 in ('46') THEN  a.i6 ELSE 0 END + CASE WHEN  a.c7 in ('46') THEN  a.i7 ELSE 0 END + \r\n" +
    "CASE WHEN  a.c8 in ('46') THEN a.i8 ELSE 0 END + CASE WHEN  a.c9 in ('46') THEN  a.i9 ELSE 0 END + CASE WHEN a.c10 in ('46') THEN a.i10 ELSE 0 END + \r\n" +
    "CASE WHEN a.c11 in ('46') THEN a.i11 ELSE 0 END + CASE WHEN a.c12 in ('46') THEN a.i12 ELSE 0 END + CASE WHEN a.c13 in ('46') THEN a.i13 ELSE 0 END + \r\n" +
    "CASE WHEN a.c14 in ('46') THEN a.i14 ELSE 0 END + CASE WHEN a.c15 in ('46') THEN a.i15 ELSE 0 END + CASE WHEN a.c16 in ('46') THEN a.i16 ELSE 0 END + \r\n" +
    "CASE WHEN a.c17 in ('46') THEN a.i17 ELSE 0 END + CASE WHEN a.c18 in ('46') THEN a.i18 ELSE 0 END + CASE WHEN a.c19 in ('46') THEN a.i19 ELSE 0 END + \r\n" +
    "CASE WHEN a.c20 in ('46') THEN a.i20 ELSE 0 END + CASE WHEN a.c21 in ('46') THEN a.i21 ELSE 0 END + CASE WHEN a.c22 in ('46') THEN a.i22 ELSE 0 END + \r\n" +
    "CASE WHEN a.c23 in ('46') THEN a.i23 ELSE 0 END + CASE WHEN a.c24 in ('46') THEN a.i24 ELSE 0 END + CASE WHEN a.c25 in ('46') THEN a.i25 ELSE 0 END + \r\n" +
    "CASE WHEN a.c26 in ('46') THEN a.i26 ELSE 0 END + CASE WHEN a.c27 in ('46') THEN a.i27 ELSE 0 END + CASE WHEN a.c28 in ('46') THEN a.i28 ELSE 0 END + \r\n" +
    "CASE WHEN a.c29 in ('46') THEN a.i29 ELSE 0 END + CASE WHEN a.c30 in ('46') THEN a.i30 ELSE 0 END + CASE WHEN a.c31 in ('46') THEN a.i31 ELSE 0 END + \r\n" +
    "CASE WHEN a.c32 in ('46') THEN a.i32 ELSE 0 END + CASE WHEN a.c33 in ('46') THEN a.i33 ELSE 0 END + CASE WHEN a.c34 in ('46') THEN a.i34 ELSE 0 END + \r\n" +
    "CASE WHEN a.c35 in ('46') THEN a.i35 ELSE 0 END + CASE WHEN a.c36 in ('46') THEN a.i36 ELSE 0 END + CASE WHEN a.c37 in ('46') THEN a.i37 ELSE 0 END + \r\n" +
    "CASE WHEN a.c38 in ('46') THEN a.i38 ELSE 0 END + CASE WHEN a.c39 in ('46') THEN a.i39 ELSE 0 END + CASE WHEN a.c40 in ('46') THEN a.i40 ELSE 0 END) ISR_meta4, \r\n" +
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
    "SUM(CASE WHEN a.c1 in ('53') THEN a.i1 ELSE 0 END + \r\n" +
    "CASE WHEN a.c2 in ('53') THEN  a.i2 ELSE 0 END + CASE WHEN  a.c3 in ('53') THEN  a.i3 ELSE 0 END + CASE WHEN a.c4 in ('53') THEN  a.i4 ELSE 0 END + \r\n" +
    "CASE WHEN a.c5 in ('53') THEN  a.i5 ELSE 0 END + CASE WHEN  a.c6 in ('53') THEN  a.i6 ELSE 0 END + CASE WHEN a.c7 in ('53') THEN  a.i7 ELSE 0 END + \r\n" +
    "CASE WHEN a.c8 in ('53') THEN  a.i8 ELSE 0 END + CASE WHEN  a.c9 in ('53') THEN  a.i9 ELSE 0 END + CASE WHEN a.c10 in ('53') THEN a.i10 ELSE 0 END + \r\n" +
    "CASE WHEN a.c11 in ('53') THEN a.i11 ELSE 0 END + CASE WHEN a.c12 in ('53') THEN a.i12 ELSE 0 END + CASE WHEN a.c13 in ('53') THEN a.i13 ELSE 0 END + \r\n" +
    "CASE WHEN a.c14 in ('53') THEN a.i14 ELSE 0 END + CASE WHEN a.c15 in ('53') THEN a.i15 ELSE 0 END + CASE WHEN a.c16 in ('53') THEN a.i16 ELSE 0 END + \r\n" +
    "CASE WHEN a.c17 in ('53') THEN a.i17 ELSE 0 END + CASE WHEN a.c18 in ('53') THEN a.i18 ELSE 0 END + CASE WHEN a.c19 in ('53') THEN a.i19 ELSE 0 END + \r\n" +
    "CASE WHEN a.c20 in ('53') THEN a.i20 ELSE 0 END + CASE WHEN a.c21 in ('53') THEN a.i21 ELSE 0 END + CASE WHEN a.c22 in ('53') THEN a.i22 ELSE 0 END + \r\n" +
    "CASE WHEN a.c23 in ('53') THEN a.i23 ELSE 0 END + CASE WHEN a.c24 in ('53') THEN a.i24 ELSE 0 END + CASE WHEN a.c25 in ('53') THEN a.i25 ELSE 0 END + \r\n" +
    "CASE WHEN a.c26 in ('53') THEN a.i26 ELSE 0 END + CASE WHEN a.c27 in ('53') THEN a.i27 ELSE 0 END + CASE WHEN a.c28 in ('53') THEN a.i28 ELSE 0 END + \r\n" +
    "CASE WHEN a.c29 in ('53') THEN a.i29 ELSE 0 END + CASE WHEN a.c30 in ('53') THEN a.i30 ELSE 0 END + CASE WHEN a.c31 in ('53') THEN a.i31 ELSE 0 END + \r\n" +
    "CASE WHEN a.c32 in ('53') THEN a.i32 ELSE 0 END + CASE WHEN a.c33 in ('53') THEN a.i33 ELSE 0 END + CASE WHEN a.c34 in ('53') THEN a.i34 ELSE 0 END + \r\n" +
    "CASE WHEN a.c35 in ('53') THEN a.i35 ELSE 0 END + CASE WHEN a.c36 in ('53') THEN a.i36 ELSE 0 END + CASE WHEN a.c37 in ('53') THEN a.i37 ELSE 0 END + \r\n" +
    "CASE WHEN a.c38 in ('53') THEN a.i38 ELSE 0 END + CASE WHEN a.c39 in ('53') THEN a.i39 ELSE 0 END + CASE WHEN a.c40 in ('53') THEN a.i40 ELSE 0 END) isr_no_timbrado \r\n" +
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

// Query para hacer la primera parte de la consulta en los registros de meta
//     select count(*) conteo,a.fec_pago,b.isr, b.registros,(count(*) - b.registros) diferencia from cosif_prueba2 a, fechas_timbrado_nomina b
// where a.anio='2022' and a.quincena='18' and a.tipo in ('0','1') and a.id_empresa='01' and a.fec_pago=b.fec_pago group by 2,3,4 order by fec_pago;
}
