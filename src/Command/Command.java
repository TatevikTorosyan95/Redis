package Command;

public class Command {
    public static void createCommand(String query) {

        String command = query;
        if ((command.split(" ")[0]).equals("set")) {
            System.out.println(stringCommands.create(command));
        } else if ((command.split(" ")[0]).equals("get")) {
            System.out.println(stringCommands.get(command));
        } else if ((command.split(" ")[0]).equals("append")) {
            System.out.println(stringCommands.append(command));
        } else if ((command.split(" ")[0]).equals("decr")) {
            stringCommands.decr(command);
        } else if ((command.split(" ")[0]).equals("incr")) {
            stringCommands.incr(command);
        } else if ((command.split(" ")[0]).equals("mget")) {
            stringCommands.mget(command);
        } else if ((command.split(" ")[0]).equals("rpush")) {
            System.out.println(ListCommands.rpush(command));
        } else if ((command.split(" ")[0]).equals("rpop")) {
            ListCommands.rpop(command);
        } else if ((command.split(" ")[0]).equals("lpush")) {
            System.out.println(ListCommands.lpush(command));
        } else if ((command.split(" ")[0]).equals("lindex")) {
            System.out.println(ListCommands.lindex(command));
        } else if ((command.split(" ")[0]).equals("linsert")) {
            ListCommands.linsert(command);
        } else if ((command.split(" ")[0]).equals("llen")) {
            ListCommands.llen(command);
        } else if ((command.split(" ")[0]).equals("lrenge")) {
            ListCommands.lrenge(command);
        } else if ((command.split(" ")[0]).equals("lset")) {
            ListCommands.lset(command);
        } else if ((command.split(" ")[0]).equals("sadd")) {
            System.out.println(setCommands.sadd(command));
        } else if ((command.split(" ")[0]).equals("scard")) {
            System.out.println(setCommands.scard(command));
        } else if ((command.split(" ")[0]).equals("sdiff")) {
            setCommands.sdiff(command);
        } else if ((command.split(" ")[0]).equals("sdiffstore")) {
            setCommands.sdiffstore(command);
        } else if ((command.split(" ")[0]).equals("sismember")) {
            setCommands.sismember(command);
        } else if ((command.split(" ")[0]).equals("sunion")) {
            setCommands.sunion(command);
        } else {
            System.out.println("Enter right command");
        }

    }
}
