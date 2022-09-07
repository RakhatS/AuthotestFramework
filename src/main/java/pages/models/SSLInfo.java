package pages.models;

public  class SSLInfo{
    private String expires,certificate_type, algorithm, signature, serial_number, MD5, SHA1;

    public SSLInfo(String expires, String certificate_type, String algorithm, String signature, String serial_number, String MD5, String SHA1) {
        this.expires = expires;
        this.certificate_type = certificate_type;
        this.algorithm = algorithm;
        this.signature = signature;
        this.serial_number = serial_number;
        this.MD5 = MD5;
        this.SHA1 = SHA1;
    }

    public SSLInfo() {
    }

    @Override
    public String toString() {
        return  "Тип сертификата= " + certificate_type + '\n' +
                "Истекает= " + expires + '\n' +
                "Алгоритм= " + algorithm + '\n' +
                "Подпись= " + signature + '\n' +
                "Серийный номер= " + serial_number + '\n' +
                "MD5= " + MD5 + '\n' +
                "SHA1= " + SHA1 ;
    }
}