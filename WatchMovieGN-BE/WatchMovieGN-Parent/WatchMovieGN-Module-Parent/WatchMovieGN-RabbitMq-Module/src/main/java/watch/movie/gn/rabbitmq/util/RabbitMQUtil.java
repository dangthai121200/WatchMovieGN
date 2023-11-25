package watch.movie.gn.rabbitmq.util;

import watch.movie.gn.util.ConstantGlobal;

public class RabbitMQUtil {
    private RabbitMQUtil() {
    }

    public static String getQueueName(String serviceName, String queueName) {
        StringBuilder stringBuilder = new StringBuilder(serviceName);
        stringBuilder.append(ConstantGlobal.UNDERSCORE);
        stringBuilder.append(queueName);
        stringBuilder.append(ConstantGlobal.DOT);
        stringBuilder.append(RabbitMQConstantGlobal.QUEUE);
        return stringBuilder.toString();
    }

    public static String getExchange(String serviceName, String exchangeName) {
        StringBuilder stringBuilder = new StringBuilder(serviceName);
        stringBuilder.append(ConstantGlobal.UNDERSCORE);
        stringBuilder.append( exchangeName);
        return stringBuilder.toString();
    }

    public static String getRoutingKey(String serviceName, String routingName) {
        StringBuilder stringBuilder = new StringBuilder(serviceName);
        stringBuilder.append(ConstantGlobal.UNDERSCORE);
        stringBuilder.append(routingName);
        stringBuilder.append(ConstantGlobal.DOT);
        stringBuilder.append(RabbitMQConstantGlobal.ROUTING);
        return stringBuilder.toString();
    }

    public static String getAction(String... actions) {
        StringBuilder stringBuilder = new StringBuilder(actions[0]);
        for (int i = 1; i < actions.length; i++) {
            stringBuilder.append(ConstantGlobal.DASH);
            stringBuilder.append(actions[i]);

        }
        return stringBuilder.toString();
    }
}
