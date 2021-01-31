package model;

import java.util.Date;

/**
 * En la interfaz es obligatorio implementar todos los métodos
 */
public interface ISchedulable {

    void schedule(Date date, String time);
}
