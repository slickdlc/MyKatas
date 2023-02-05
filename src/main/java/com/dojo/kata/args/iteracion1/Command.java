package com.dojo.kata.args.iteracion1;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

abstract class Command {
    protected List<Character> integerArguments = Collections.emptyList();
    protected List<Character> booleanArguments = Collections.emptyList();
    protected List<Character> stringArguments = Collections.emptyList();
    protected HashMap<Character, Integer> integerHashMap = new HashMap<>();
    protected HashMap<Character, String> stringHashMap = new HashMap<>();
    protected HashMap<Character, Boolean> booleanHashMap = new HashMap<>();

    public Command(List<Character> integerArguments,
                   List<Character> booleanArguments,
                   List<Character> stringArguments) {
        this.integerArguments = integerArguments;
        this.booleanArguments = booleanArguments;
        this.stringArguments = stringArguments;
    }

    public void call(String stringArguments) throws InvalidArgumentsException {
        this.initializeAttributes();
        if (!stringArguments.isEmpty()) {
            this.setArguments(stringArguments);
        }
        this.callCommand();
    }

    protected void initializeAttributes() {
    }

    protected void setArguments(String stringArguments) throws InvalidArgumentsException {
        String[] args = stringArguments.split(" ");
        for (int i = 0; i < args.length; i++) {
            if (!args[i].contains("-")) {
                throw new InvalidArgumentsException();
            }
            Character arg = args[i].charAt(1);
            if (findInBooleanArguments(arg)) {
                this.booleanHashMap.put(arg, true);
            } else if (findInIntegerArguments(arg)) {
                this.integerHashMap.put(arg, Integer.valueOf(args[++i]));
            } else if (findInStringArguments(arg)) {
                this.stringHashMap.put(arg, args[++i]);
            } else {
                throw new InvalidArgumentsException();
            }
        }
//        if(Arrays.stream(this.booleanArguments).allMatch()){
//
//        }

    }

    protected boolean findInBooleanArguments(Character arg) {

        return this.booleanArguments.contains(arg);
    }

    protected boolean findInIntegerArguments(Character arg) {
        return this.integerArguments.contains(arg);
    }

    protected boolean findInStringArguments(Character arg) {
        return this.stringArguments.contains(arg);
    }

    protected void callCommand() {
        //do nothing
    }

}
