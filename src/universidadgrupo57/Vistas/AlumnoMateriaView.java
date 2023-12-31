/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo57.Vistas;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import universidadgrupo57.AccesoADatos.AlumnoData;
import universidadgrupo57.AccesoADatos.InscripcionData;
import universidadgrupo57.AccesoADatos.MateriaData;
import universidadgrupo57.Entidades.Alumno;
import universidadgrupo57.Entidades.Materia;


public class AlumnoMateriaView extends javax.swing.JFrame {

    /**
     * Creates new form AlumnoMateriaView
     */
    
    private DefaultTableModel alumnosModel;
    private MateriaData materiaData;
    private InscripcionData inscripcionData;
    
    
    public AlumnoMateriaView() {
        initComponents();
        
        this.materiaData = new MateriaData();
        this.inscripcionData = new InscripcionData();
        
        List<Materia> materias = materiaData.listarMaterias();
        //se obtiene id, nombre, año y estado para cada materia
        for (Materia materia : materias) {
            int idMateria = materia.getIdMateria();
            String nombre = materia.getNombre();
            int anio = materia.getAnio();
            int estado;
            
            if (materia.isEstado()) {
                estado = 1;
            } else {
                estado = 0;
            }            
         //se muestran en el combo box   
            materiaComboBox.addItem(
                    idMateria + ", " + materia.getNombre() + ", " + anio );
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alumnosTable = new javax.swing.JTable();
        materiaComboBox = new javax.swing.JComboBox<>();
        salirButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(420, 335));

        alumnosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "Apellido", "Nombre"
            }
        ));
        alumnosTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(alumnosTable);

        materiaComboBox.setBorder(null);
        materiaComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materiaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materiaComboBoxActionPerformed(evt);
            }
        });

        salirButton.setBackground(new java.awt.Color(51, 153, 255));
        salirButton.setText("Salir");
        salirButton.setBorder(null);
        salirButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel2.setText("Seleccione una materia:");

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(416, 30));
        jPanel2.setPreferredSize(new java.awt.Dimension(416, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 2, 18)); // NOI18N
        jLabel1.setText("Alumnos por materia");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel3.setText("Listado de alumnos por materia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(materiaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel3)))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(materiaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(salirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void materiaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materiaComboBoxActionPerformed
        //se obtiene el elemento seleccionado y se convierte a string
        String selec = materiaComboBox.getSelectedItem().toString();
        //busca la posicion de la primera coma en el seleccionado
        //muestra la separacion entre idMateria y el resto
        int coma = selec.indexOf(',');
        //verifica si se encontró una coma
        if (coma != -1) {
        //se obtiene el idMateria desde el primer indice hasta la coma    
            String numero = selec.substring(0, coma);
        //parseo a int el idMateria    
            int primernro = Integer.parseInt(numero);            
         //utilizo el id obtenido para llamar al metodo buscar
         //devuelve alumnos inscriptos en la materia con ese id
            List<Alumno> alumnos = inscripcionData.obtenerAlumnosXMateria(primernro);            
            
            rellenarTabla(alumnos);
        }
        
        
    }//GEN-LAST:event_materiaComboBoxActionPerformed

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlumnoMateriaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnoMateriaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnoMateriaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnoMateriaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlumnoMateriaView().setVisible(true);
            }
        });
    }
    
    public void rellenarTabla(List<Alumno> alumnos) {
    //defino los nombres de las columnas con este arreglo string
        String columnas[] = {
        "ID", "DNI", "Apellido", "Nombre"
    };
   //otro arreglo para almacenar los datos de los alumnos que se mostraran en la tabla
    String data[][] = new String[alumnos.size()][4];
   //para recorrer la lista de alumnos
    for (int i = 0; i < alumnos.size(); i++) {
        Alumno alumno = alumnos.get(i);
        data[i][0] = String.valueOf(alumno.getIdAlumno());
        data[i][1] = String.valueOf(alumno.getDni());
        data[i][2] = alumno.getApellido();
        data[i][3] = alumno.getNombre();
    }
   //para mostrar los datos en la tabla
    alumnosModel = new DefaultTableModel(data, columnas);
    alumnosTable.setModel(alumnosModel);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable alumnosTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> materiaComboBox;
    private javax.swing.JButton salirButton;
    // End of variables declaration//GEN-END:variables
}
