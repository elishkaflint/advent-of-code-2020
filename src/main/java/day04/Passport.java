package day04;

import day04.validation.EyeColour;
import day04.validation.ValidEyeColour;
import day04.validation.ValidHeight;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Passport {

    @Min(1920)
    @Max(2002)
    private int byr;

    @Min(2010)
    @Max(2020)
    private int iyr;

    @Min(2020)
    @Max(2030)
    private int eyr;

    @ValidHeight
    private String hgt;

    @Pattern(regexp = "#[0-9a-f]{6}")
    @NotNull
    private String hcl;

    @ValidEyeColour(enumClass = EyeColour.class)
    private String ecl;

    @Size(min = 9, max = 9)
    @NotNull
    private String pid;

    private String cid;

    public int getByr() {
        return byr;
    }

    public void setByr(String byr) {
        this.byr = Integer.parseInt(byr);
    }

    public int getIyr() {
        return iyr;
    }

    public void setIyr(String iyr) {
        this.iyr = Integer.parseInt(iyr);
    }

    public int getEyr() {
        return eyr;
    }

    public void setEyr(String eyr) {
        this.eyr = Integer.parseInt(eyr);
    }

    public String getHgt() {
        return hgt;
    }

    public void setHgt(String hgt) {
        this.hgt = hgt;
    }

    public String getHcl() {
        return hcl;
    }

    public void setHcl(String hcl) {
        this.hcl = hcl;
    }

    public String getEcl() {
        return ecl;
    }

    public void setEcl(String ecl) {
        this.ecl = ecl;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setField(String field, String value) {
        switch (field) {
            case("byr"): {
                this.setByr(value);
                return;
            }
            case("iyr"): {
                this.setIyr(value);
                return;
            }
            case("eyr"): {
                this.setEyr(value);
                return;
            }
            case("hgt"): {
                this.setHgt(value);
                return;
            }
            case("hcl"): {
                this.setHcl(value);
                return;
            }
            case("ecl"): {
                this.setEcl(value);
                return;
            }
            case("pid"): {
                this.setPid(value);
                return;
            }
            case("cid"): {
                this.setCid(value);
                return;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + field);
        }
    }

    @Override
    public String toString() {
        return "Passport{" +
                "byr=" + byr +
                ", iyr=" + iyr +
                ", eyr=" + eyr +
                ", hcl='" + hcl + '\'' +
                ", ecl='" + ecl + '\'' +
                ", pid='" + pid + '\'' +
                ", hgt='" + hgt + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }
}
