package com.dojo.kata.args.iteracion1;

import java.util.Arrays;

public class PrintNumbersCommand extends Command {
    private static final Character EVEN_FLAG = 'e';
    private static final Character ODD_FLAG = 'o';

    private static final Character ARGUMENT_FIRST = 'f';
    private static final Character ARGUMENT_LAST = 'l';
    private static final Character ARGUMENT_SUFFIX = 's';
    private static final Character ARGUMENT_PREFIX = 'p';

    public PrintNumbersCommand() {
        super(Arrays.asList(ARGUMENT_FIRST, ARGUMENT_LAST)
                , Arrays.asList(EVEN_FLAG, ODD_FLAG)
                , Arrays.asList(ARGUMENT_SUFFIX, ARGUMENT_PREFIX));

        this.booleanHashMap.put(ODD_FLAG, false);
        this.booleanHashMap.put(EVEN_FLAG, false);
        this.integerHashMap.put(ARGUMENT_FIRST, 1);
        this.integerHashMap.put(ARGUMENT_LAST, 1000);
        this.stringHashMap.put(ARGUMENT_SUFFIX, "");
        this.stringHashMap.put(ARGUMENT_PREFIX, "");
    }

    @Override
    public void call(String stringArguments) throws InvalidArgumentsException {
        super.call(stringArguments);
    }

    @Override
    protected void callCommand() {
        Integer initialValue = integerHashMap.getOrDefault(ARGUMENT_FIRST, 1);
        Integer lastValue = integerHashMap.getOrDefault(ARGUMENT_LAST, 1000);
        String suffixValue = stringHashMap.getOrDefault(ARGUMENT_SUFFIX, "");
        String prefixValue = stringHashMap.getOrDefault(ARGUMENT_PREFIX, "");
        Boolean showEven = !this.booleanHashMap.getOrDefault(EVEN_FLAG, false);
        Boolean showOdd = !this.booleanHashMap.getOrDefault(ODD_FLAG, false);
        for (int i = initialValue; i <= lastValue; i++) {
            if (i % 2 == 0) {
                if (showEven) {
                    System.out.print(prefixValue + i + suffixValue);
                }
            } else {
                if (showOdd) {
                    System.out.print(prefixValue + i + suffixValue);
                }
            }
        }
    }
}
