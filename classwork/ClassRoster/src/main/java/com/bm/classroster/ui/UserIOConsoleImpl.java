/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.classroster.ui;

import java.util.Scanner;


public class UserIOConsoleImpl implements UserIO {
    private Scanner reader;
    
    public UserIOConsoleImpl(Scanner reader) {
        this.reader = reader;
    }
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return reader.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        int retr = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(prompt);
            try {
                retr = Integer.parseInt(reader.nextLine());
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("!! That input could not be converted to an int !!");
            }           
        }
        return retr;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int retr = -1;
        boolean isValid = false;
        while (!isValid) {
           System.out.println(prompt);
            try {
                retr = Integer.parseInt(reader.nextLine());
                isValid = (min <= retr) && (retr <= max);
                if (!isValid) {
                    System.out.format(
                        "!! The input must be in the range [%d, %d] !!%n",
                        min,
                        max
                    );
                }
            } catch (NumberFormatException ex) {
                System.out.println("!! That input could not be converted to an int !!");
            }           
        }
        return retr;
    }

    @Override
    public double readDouble(String prompt) {
        double retr = -1;
        boolean isValid = false;
        while (!isValid) {
           System.out.println(prompt);
            try {
                retr = Double.parseDouble(reader.nextLine());
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("!! That input could not be converted to a double !!");
            }           
        }
        return retr;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double retr = -1;
        boolean isValid = false;
        while (!isValid) {
           System.out.println(prompt);
            try {
                retr = Double.parseDouble(reader.nextLine());
                isValid = (min <= retr) && (retr <= max);
                if (!isValid) {
                    System.out.format(
                        "!! The input must be in the range [%f, %f] !!%n",
                        min,
                        max
                    );
                }
            } catch (NumberFormatException ex) {
                System.out.println("!! That input could not be converted to a double !!");
            }           
        }
        return retr;
    }

    @Override
    public float readFloat(String prompt) {
        float retr = -1;
        boolean isValid = false;
        while (!isValid) {
           System.out.println(prompt);
            try {
                retr = Float.parseFloat(reader.nextLine());
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("!! That input could not be converted to a float !!");
            }
        }
        return retr;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float retr = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(prompt);
            try {
                retr = Float.parseFloat(reader.nextLine());
                isValid = (min <= retr) && (retr <= max);
                if (!isValid) {
                    System.out.format(
                        "!! The input must be in the range [%f, %f] !!%n",
                        min,
                        max
                    );
                }
            } catch (NumberFormatException ex) {
                System.out.println("!! That input could not be converted to a float !!");
            }           
        }
        return retr;
    }

    @Override
    public long readLong(String prompt) {
        long retr = -1;
        boolean isValid = false;
        while (!isValid) {
           System.out.println(prompt);
            try {
                retr = Long.parseLong(reader.nextLine());
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("!! That input could not be converted to a long !!");
            }           
        }
        return retr;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long retr = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(prompt);
            try {
                retr = Long.parseLong(reader.nextLine());
                isValid = (min <= retr) && (retr <= max);
                if (!isValid) {
                    System.out.format(
                        "!! The input must be in the range [%d, %d] !!%n",
                        min,
                        max
                    );
                }
            } catch (NumberFormatException ex) {
                System.out.println("!! That input could not be converted to a long !!");
            }           
        }
        return retr;
    }
}