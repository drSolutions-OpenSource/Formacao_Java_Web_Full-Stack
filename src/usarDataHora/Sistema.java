package usarDataHora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Datas, tempo e período com a API DateTime
 * O ideal é usar o Calendar(), pois ele é mais novo no Java e com mais recursos.
 *
 * @author Diego Mendes Rodrigues
 */
public class Sistema {
    static String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
    static String[] diasDaSemanaDate = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
    static String[] diasDaSemanaCalendar = {"Sab", "Dom", "Seg", "Ter", "Qua", "Qui", "Sex"};

    public static void main(String[] args) {
        /*
         * Executar um exemplo de data e hora por vez
         */
        usarDate();

//        formatarComSimpleDateFormat();

//        usarCalendar();

//        compararDateAfterBefore();

//        compararCalendarAfterBefore();

//        CalcularDatas calcularDatas = new CalcularDatas();
    }

    /**
     * Usar o Date() de java.util
     */
    public static void usarDate() {
        Date data = new Date();

        System.out.println("Date()");
        System.out.println("Data................: " + data);
        System.out.println("Dia do mês..........: " + data.getDate());
        System.out.println("Mês.................: " + meses[data.getMonth()]);
        System.out.println("Ano.................: " + mostrarAno(data.getYear()));
        System.out.println("Hora................: " + data.getHours());
        System.out.println("Minuto..............: " + data.getMinutes());
        System.out.println("Segundo.............: " + data.getSeconds());
        System.out.println("Dia da Semana.......: " + data.getDay());
        System.out.println("Dia da Semana.......: " + diasDaSemanaDate[data.getDay()]);
        System.out.println("Data em milisegundos: " + data.getTime());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm.ss");
        System.out.println("Data formatada......: " + simpleDateFormat.format(data));

        System.out.println(" ");
    }

    /**
     * Retornar o ano atual, pois o Date.getYear() retorna o ano a partir de 1900.
     *
     * @param ano proveniente de Date.getYear()
     * @return o ano atual
     */
    public static int mostrarAno(int ano) {
        return ano + 1900;
    }

    /**
     * Formatar as datas para a exibição na tela, ou para utilizar com o banco de dados
     */
    public static void formatarComSimpleDateFormat() {
        Date data = new Date();

        System.out.println("SimpleDateFormat()");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Data: " + simpleDateFormat.format(data));

        simpleDateFormat = new SimpleDateFormat("HH:mm.ss");
        System.out.println("Hora: " + simpleDateFormat.format(data));

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm.ss");
        System.out.println("Banco de Dados: " + simpleDateFormat.format(data));

        /* Fazer o parser de uma String para uma Data */
        System.out.println("Parser de data de uma String");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat sdfAniversario = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date nascimento = new Date();
        try {
            nascimento = sdf.parse("1982-07-08 14:25");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sdfAniversario.format(nascimento));

        System.out.println(" ");
    }

    /**
     * Utilizar o Calendar()
     * A numeração dos dias da semana é diferente da utilizada em Date()
     */
    public static void usarCalendar() {
        Calendar calendar = Calendar.getInstance();

        System.out.println("Calendar()");
        System.out.println("Data................: " + calendar.getTime());
        System.out.println("Dia do mês..........: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Mês.................: " + meses[calendar.get(Calendar.MONTH)]);
        System.out.println("Ano.................: " + calendar.get(Calendar.YEAR));
        System.out.println("Hora................: " + calendar.get(Calendar.HOUR));
        System.out.println("Hora do dia.........: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minuto..............: " + calendar.get(Calendar.MINUTE));
        System.out.println("Segundo.............: " + calendar.get(Calendar.SECOND));
        System.out.println("Dia da Semana.......: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Dia da Semana.......: " + diasDaSemanaCalendar[calendar.get(Calendar.DAY_OF_WEEK)]);
        System.out.println("Data em milisegundos: " + (long) calendar.getTimeInMillis());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm.ss");
        System.out.println("Data formatada......: " + simpleDateFormat.format(calendar.getTime()));

        System.out.println(" ");
    }

    /**
     * Comparar 2 datas com Date.after() e Date.before()
     */
    public static void compararDateAfterBefore() {
        System.out.println("Date.after() e Date.before()");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataVencimento = null;
        Date dataAtual = null;

        try {
            dataVencimento = simpleDateFormat.parse("10/11/2023");
            dataAtual = simpleDateFormat.parse("20/11/2023");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        /* Data atual é depois que a data de vencimento? */
        if (dataAtual.after(dataVencimento)) {
            System.out.println("Boleto vencido, pois a data atual é depois que a data de vencimento");
        } else {
            System.out.println("Boleto pode ser pago, pois a data atual é igual ou depois que de vencimento");
        }

        /* Data de vencimento é antes que a data atual? */
        if (dataVencimento.before(dataAtual)) {
            System.out.println("Boleto vencido, pois a data de vencimento é antes que a atual");
        } else {
            System.out.println("Boleto pode ser pago, pois a data de vencimento é igual ou depois que a atual");
        }
        System.out.println(" ");
    }

    /**
     * Comparar 2 datas com Calendar.after() e Calendar.before()
     */
    public static void compararCalendarAfterBefore() {
        System.out.println("Calendar.after() e Calendar.before()");

        Calendar dataVencimento = Calendar.getInstance();
        Calendar dataAtual = Calendar.getInstance();
        dataVencimento.set(2023, Calendar.DECEMBER, 10);
        dataAtual.set(2023, Calendar.DECEMBER, 20);

        /* Data atual é depois que a data de vencimento? */
        if (dataAtual.after(dataVencimento)) {
            System.out.println("Boleto vencido, pois a data atual é depois que a data de vencimento");
        } else {
            System.out.println("Boleto pode ser pago, pois a data atual é igual ou depois que de vencimento");
        }

        /* Data de vencimento é antes que a data atual? */
        if (dataVencimento.before(dataAtual)) {
            System.out.println("Boleto vencido, pois a data de vencimento é antes que a atual");
        } else {
            System.out.println("Boleto pode ser pago, pois a data de vencimento é igual ou depois que a atual");
        }
        System.out.println(" ");
    }
}
