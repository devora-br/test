package com.company;

import java.util.Collections;
import java.util.List;

public class ActionsImpl implements Actions{

    public List<String> sort(List<String> lines){
        Collections.sort(lines);
        return lines;
    }

    public List<String> reverse(List<String> lines){
        Collections.reverse(lines);
        return lines;
    }

    public List<String> shuffle(List<String> lines){
        Collections.shuffle(lines);
        return lines;
    }
}
