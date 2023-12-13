package usarDataHora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Realizar o cálculo com adição e subtração de datas
 *
 * @author Diego Mendes Rodrigues
 */
public class CalcularDatas {
    static String[] diasDaSemanaCalendar = {"Sab", "Dom", "Seg", "Ter", "Qua", "Qui", "Sex"};

    public CalcularDatas() {
        /*
         * Executar um exemplo de data e hora por vez
         */
        adicionarSubtrairDias();

        adicionarSubtrairMesAno();

//        diferencaEntreDatas();
    }

    /**
     * Adicionar e subtrair dias em uma data
     */
    public void adicionarSubtrairDias() {
        System.out.println("# Adicionar s subtrair Dias");

        /* Data atual */
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        /* Definir uma data que recebemos como String */
        try {
            calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("12-12-2023"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        /* Data definida */
        System.out.println("Data definida: " + simpleDateFormat.format(calendar.getTime()));

        /* Adicionar e remover dias do mês */
        System.out.println("# Adicionar dias do Mês");
        calendar.add(Calendar.DAY_OF_MONTH, 5);
        System.out.println("Data (+5)....: " + simpleDateFormat.format(calendar.getTime()));

        calendar.add(Calendar.DAY_OF_MONTH, 35);
        System.out.println("Data (+35)...: " + simpleDateFormat.format(calendar.getTime()));

        calendar.add(Calendar.DAY_OF_MONTH, -3);
        System.out.println("Data (-3)....: " + simpleDateFormat.format(calendar.getTime()));
        System.out.println(" ");

        /* Adicionar e remover dias da semana */
        System.out.println("# Adicionar dias da Semana");
        System.out.println("Data definida: " + simpleDateFormat.format(calendar.getTime()));
        System.out.println("Dia Semana...: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Dia Semana...: " + diasDaSemanaCalendar[calendar.get(Calendar.DAY_OF_WEEK)]);

        calendar.add(Calendar.DAY_OF_WEEK, 3);
        System.out.println("Dia Semana (+3)....: " + simpleDateFormat.format(calendar.getTime()));
        System.out.println("Dia Semana...: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Dia Semana...: " + diasDaSemanaCalendar[calendar.get(Calendar.DAY_OF_WEEK)]);

        calendar.add(Calendar.DAY_OF_WEEK, 5);
        System.out.println("Dia Semana (+5)....: " + simpleDateFormat.format(calendar.getTime()));
        System.out.println("Dia Semana...: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Dia Semana...: " + diasDaSemanaCalendar[calendar.get(Calendar.DAY_OF_WEEK)]);

        System.out.println(" ");
    }

    /**
     * Adicionar e subtrair meses ou anos em uma data
     */
    public void adicionarSubtrairMesAno() {
        System.out.println("# Adicionar s subtrair Meses e Anos");

        /* Data atual */
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        /* Definir uma data que recebemos como String */
        try {
            calendar.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("12-12-2023"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        /* Data definida */
        System.out.println("Data definida: " + simpleDateFormat.format(calendar.getTime()));

        /* Adicionar e remover meses */
        calendar.add(Calendar.MONTH, 5);
        System.out.println("Mês (+5).....: " + simpleDateFormat.format(calendar.getTime()));

        calendar.add(Calendar.MONTH, 17);
        System.out.println("Mês (+17)....: " + simpleDateFormat.format(calendar.getTime()));

        calendar.add(Calendar.MONTH, -3);
        System.out.println("Mês (-3).....: " + simpleDateFormat.format(calendar.getTime()));

        /* Adicionar e remover anos */
        calendar.add(Calendar.YEAR, -8);
        System.out.println("Ano (-8).....: " + simpleDateFormat.format(calendar.getTime()));

        calendar.add(Calendar.YEAR, +4);
        System.out.println("Ano (+4).....: " + simpleDateFormat.format(calendar.getTime()));

        System.out.println(" ");
    }

    /**
     * Demonstrar o cálculo de diferença entre duas datas, em dias, semanas e anos
     */
    public void diferencaEntreDatas() {
        System.out.println("# Diferença entre dias");
        Calendar data1 = Calendar.getInstance();
        Calendar data2 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            data1.setTime(simpleDateFormat.parse("05/11/2023"));
            data2.setTime(simpleDateFormat.parse("10/12/2023"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        /* Datas */
        System.out.println("Data 1: " + simpleDateFormat.format(data1.getTime()));
        System.out.println("Data 2: " + simpleDateFormat.format(data2.getTime()));

        /* Diferença de dias */
        int dias = diferencaDeDias(data2, data1);
        System.out.println("Dias..: " + dias);
        System.out.println(" ");

        System.out.println("# Diferença entre semanas");
        try {
            data2.setTime(simpleDateFormat.parse("14/12/2023"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Data 1..: " + simpleDateFormat.format(data1.getTime()));
        System.out.println("Data 2..: " + simpleDateFormat.format(data2.getTime()));
        float semanas = diferencaDeSemanas(data2, data1);
        System.out.println("Semanas.: " + semanas);
        System.out.println(" ");

        System.out.println("# Diferença entre anos");
        try {
            data1.setTime(simpleDateFormat.parse("05/11/2021"));
            data2.setTime(simpleDateFormat.parse("14/12/2023"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Data 1: " + simpleDateFormat.format(data1.getTime()));
        System.out.println("Data 2: " + simpleDateFormat.format(data2.getTime()));
        float anos = diferencaDeAnos(data2, data1);
        System.out.println("Anos..: " + anos);

        System.out.println(" ");
    }

    /**
     * Calcular a diferença de dias entre 2 datas
     *
     * @param calendar1 sendo a data mais recente
     * @param calendar2 sendo a data mais antiga
     * @return a diferença de dias
     */
    public static int diferencaDeDias(Calendar calendar1, Calendar calendar2) {
        int MILLIS_IN_DAY = 86400000;
        long MILLIS_IN_WEEK = (long) MILLIS_IN_DAY * 7;
        long MILLIS_IN_YEAR = (long) MILLIS_IN_DAY * 365;

        calendar1.set(Calendar.MILLISECOND, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);

        calendar2.set(Calendar.MILLISECOND, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);

        return (int) ((calendar1.getTimeInMillis() - calendar2.getTimeInMillis()) / MILLIS_IN_DAY);
    }

    /**
     * Calcular a diferença de semanas entre 2 datas
     *
     * @param calendar1 sendo a data mais recente
     * @param calendar2 sendo a data mais antiga
     * @return a diferença de semanas
     */
    public static float diferencaDeSemanas(Calendar calendar1, Calendar calendar2) {
        int MILLIS_IN_DAY = 86400000;
        float MILLIS_IN_WEEK = (long) MILLIS_IN_DAY * 7;

        calendar1.set(Calendar.MILLISECOND, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);

        calendar2.set(Calendar.MILLISECOND, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);

        return (float) ((calendar1.getTimeInMillis() - calendar2.getTimeInMillis()) / MILLIS_IN_WEEK);
    }

    /**
     * Calcular a diferença de meses entre 2 datas
     *
     * @param calendar1 sendo a data mais recente
     * @param calendar2 sendo a data mais antiga
     * @return a diferença de meses
     */
    public static float diferencaDeAnos(Calendar calendar1, Calendar calendar2) {
        int MILLIS_IN_DAY = 86400000;
        float MILLIS_IN_YEAR = (long) MILLIS_IN_DAY * 365;

        calendar1.set(Calendar.MILLISECOND, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.HOUR_OF_DAY, 0);

        calendar2.set(Calendar.MILLISECOND, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);

        return (float) ((calendar1.getTimeInMillis() - calendar2.getTimeInMillis()) / MILLIS_IN_YEAR);
    }
}
