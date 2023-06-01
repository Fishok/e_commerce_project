package com.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuppressWarnings("serial")
public class CollectsDTO implements Serializable {
    private String nameCollection;
    

}
