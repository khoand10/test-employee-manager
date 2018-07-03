package com.codegym.employeemanager.fomater;

import com.codegym.employeemanager.model.Group;
import com.codegym.employeemanager.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class GroupFormater implements Formatter<Group> {

    private GroupService groupService;
    public GroupFormater(GroupService groupService){
        this.groupService = groupService;
    }

    @Override
    public Group parse(String text, Locale locale) throws ParseException {
        Long id = Long.parseLong(text);
        return groupService.findById(id);
    }

    @Override
    public String print(Group object, Locale locale) {
        return object.getName();
    }
}
