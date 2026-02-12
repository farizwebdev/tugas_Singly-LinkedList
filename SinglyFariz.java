// CLASS NODE MANUAL
class Node {
    String nim;
    String nama;
    String jk;
    Node next;

    public Node(String nim, String nama, String jk) {
        this.nim = nim;
        this.nama = nama;
        this.jk = jk;
        this.next = null;
    }
}

public class SinglyFariz {
    public static void main(String[] args) {
        Node head = null;
        int count = 0;
        int choice;

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // HEADER
        System.out.println("\n=================================================");
        System.out.println("       TUGAS STRUKTUR DATA LINKED LIST           ");
        System.out.println("=================================================");
        System.out.println(" Nama    : Fariz Husain Albar");
        System.out.println(" Kelas   : Informatika A");
        System.out.println(" NIM     : 24106050011");
        System.out.println(" Matkul  : Struktur Data");
        System.out.println("=================================================");
        System.out.println(" >> Tekan ENTER untuk masuk ke Menu Program...");
        sc.nextLine();

        while (true) {
            System.out.println("\n=== MENU MAHASISWA (Count: " + count + ") ===");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at given position");
            System.out.println("3. Insert at end");
            System.out.println("4. Delete from beginning");
            System.out.println("5. Delete given position");
            System.out.println("6. Delete from end");
            System.out.println("7. Delete first occurence (by NIM)");
            System.out.println("8. Show data");
            System.out.println("9. Exit");
            System.out.print("Pilih menu: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println(">> Input salah! Harap masukkan angka.");
                sc.next();
                continue;
            }

            // 1. INSERT AT BEGINNING
            if (choice == 1) {
                // Validasi NIM
                String nim = "";
                while (true) {
                    System.out.print("Masukkan NIM: ");
                    nim = sc.nextLine();
                    if (!nim.matches("[0-9]+")) {
                        System.out.println(">> ERROR: NIM harus angka!");
                        continue;
                    }
                    boolean exists = false;
                    Node temp = head;
                    while (temp != null) {
                        if (temp.nim.equals(nim)) { exists = true; break; }
                        temp = temp.next;
                    }
                    if (exists) System.out.println(">> ERROR: NIM sudah ada!");
                    else break;
                }

                // Validasi Nama
                String nama = "";
                while (true) {
                    System.out.print("Masukkan Nama: ");
                    nama = sc.nextLine();
                    boolean exists = false;
                    Node temp = head;
                    while (temp != null) {
                        if (temp.nama.equalsIgnoreCase(nama)) { exists = true; break; }
                        temp = temp.next;
                    }
                    if (exists) System.out.println(">> ERROR: Nama sudah ada!");
                    else break;
                }

                // Validasi JK
                String jk = "";
                while (true) {
                    System.out.print("Masukkan Jenis Kelamin (L/P): ");
                    String inputJk = sc.nextLine().toUpperCase();
                    if (inputJk.equals("L") || inputJk.equals("P")) {
                        jk = inputJk;
                        break;
                    }
                    System.out.println(">> ERROR: Input salah (L/P)!");
                }

                Node newNode = new Node(nim, nama, jk);
                if (head == null) {
                    head = newNode;
                } else {
                    newNode.next = head;
                    head = newNode;
                }
                count++;
                System.out.println(">> SUKSES: Data insert di depan.");
            }

            // 2. INSERT AT GIVEN POSITION
            else if (choice == 2) {
                int pos = 0;
                while (true) {
                    System.out.print("Masukkan Posisi Insert (1 - " + (count + 1) + "): ");
                    if (sc.hasNextInt()) {
                        pos = sc.nextInt();
                        sc.nextLine();
                        if (pos >= 1 && pos <= count + 1) break;
                        System.out.println(">> ERROR: Posisi tidak valid!");
                    } else {
                        System.out.println(">> ERROR: Harap masukkan angka!");
                        sc.next();
                    }
                }

                // INPUT DATA SAMA SEPERTI DI ATAS
                String nim = "";
                while (true) {
                    System.out.print("Masukkan NIM: "); nim = sc.nextLine();
                    if (!nim.matches("[0-9]+")) { System.out.println(">> ERROR: NIM harus angka!"); continue; }
                    boolean exists = false; Node temp = head;
                    while (temp != null) { if (temp.nim.equals(nim)) { exists = true; break; } temp = temp.next; }
                    if (exists) System.out.println(">> ERROR: NIM sudah ada!"); else break;
                }
                String nama = "";
                while (true) {
                    System.out.print("Masukkan Nama: "); nama = sc.nextLine();
                    boolean exists = false; Node temp = head;
                    while (temp != null) { if (temp.nama.equalsIgnoreCase(nama)) { exists = true; break; } temp = temp.next; }
                    if (exists) System.out.println(">> ERROR: Nama sudah ada!"); else break;
                }
                String jk = "";
                while (true) {
                    System.out.print("Masukkan Jenis Kelamin (L/P): "); String inputJk = sc.nextLine().toUpperCase();
                    if (inputJk.equals("L") || inputJk.equals("P")) { jk = inputJk; break; }
                    System.out.println(">> ERROR: Input salah (L/P)!");
                }

                Node newNode = new Node(nim, nama, jk);
                if (pos == 1) {
                    newNode.next = head;
                    head = newNode;
                } else {
                    Node current = head;
                    for (int i = 1; i < pos - 1; i++) {
                        current = current.next;
                    }
                    newNode.next = current.next;
                    current.next = newNode;
                }
                count++;
                System.out.println(">> SUKSES: Data insert di posisi " + pos);
            }

            // 3. INSERT AT END
            else if (choice == 3) {
                String nim = "";
                while (true) {
                    System.out.print("Masukkan NIM: "); nim = sc.nextLine();
                    if (!nim.matches("[0-9]+")) { System.out.println(">> ERROR: NIM harus angka!"); continue; }
                    boolean exists = false; Node temp = head;
                    while (temp != null) { if (temp.nim.equals(nim)) { exists = true; break; } temp = temp.next; }
                    if (exists) System.out.println(">> ERROR: NIM sudah ada!"); else break;
                }
                String nama = "";
                while (true) {
                    System.out.print("Masukkan Nama: "); nama = sc.nextLine();
                    boolean exists = false; Node temp = head;
                    while (temp != null) { if (temp.nama.equalsIgnoreCase(nama)) { exists = true; break; } temp = temp.next; }
                    if (exists) System.out.println(">> ERROR: Nama sudah ada!"); else break;
                }
                String jk = "";
                while (true) {
                    System.out.print("Masukkan Jenis Kelamin (L/P): "); String inputJk = sc.nextLine().toUpperCase();
                    if (inputJk.equals("L") || inputJk.equals("P")) { jk = inputJk; break; }
                    System.out.println(">> ERROR: Input salah (L/P)!");
                }

                Node newNode = new Node(nim, nama, jk);
                if (head == null) {
                    head = newNode;
                } else {
                    Node temp = head;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = newNode;
                }
                count++;
                System.out.println(">> SUKSES: Data insert di akhir.");
            }

            // 4. DELETE FROM BEGINNING
            else if (choice == 4) {
                if (head == null) {
                    System.out.println(">> GAGAL: LinkedList Kosong!");
                } else {
                    head = head.next;
                    count--;
                    System.out.println(">> SUKSES: Data pertama dihapus.");
                }
            }

            // 5. DELETE GIVEN POSITION
            else if (choice == 5) {
                if (head == null) {
                    System.out.println(">> GAGAL: LinkedList Kosong!");
                } else {
                    int pos = 0;
                    while (true) {
                        System.out.print("Masukkan Posisi Hapus (1 - " + count + "): ");
                        if (sc.hasNextInt()) {
                            pos = sc.nextInt(); sc.nextLine();
                            if (pos >= 1 && pos <= count) break;
                            System.out.println(">> ERROR: Posisi tidak valid!");
                        } else { System.out.println(">> ERROR: Harap masukkan angka!"); sc.next(); }
                    }

                    if (pos == 1) {
                        head = head.next;
                    } else {
                        Node temp = head;
                        for (int i = 1; i < pos - 1; i++) {
                            temp = temp.next;
                        }
                        Node nodeToDelete = temp.next;
                        temp.next = nodeToDelete.next;
                    }
                    count--;
                    System.out.println(">> SUKSES: Data posisi " + pos + " dihapus.");
                }
            }

            // 6. DELETE FROM END
            else if (choice == 6) {
                if (head == null) {
                    System.out.println(">> GAGAL: LinkedList Kosong!");
                } else if (head.next == null) {
                    head = null;
                    count--;
                    System.out.println(">> SUKSES: Data terakhir dihapus.");
                } else {
                    Node temp = head;
                    while (temp.next.next != null) {
                        temp = temp.next;
                    }
                    temp.next = null;
                    count--;
                    System.out.println(">> SUKSES: Data terakhir dihapus.");
                }
            }

            // 7. DELETE FIRST OCCURRENCE (BY NIM)
            else if (choice == 7) {
                if (head == null) {
                    System.out.println(">> GAGAL: LinkedList Kosong!");
                } else {
                    System.out.print("Masukkan NIM yang akan dihapus: ");
                    String targetNim = sc.nextLine();

                    if (head.nim.equals(targetNim)) {
                        head = head.next;
                        count--;
                        System.out.println(">> SUKSES: NIM " + targetNim + " dihapus.");
                    } else {
                        Node temp = head;
                        boolean found = false;
                        while (temp.next != null) {
                            if (temp.next.nim.equals(targetNim)) {
                                temp.next = temp.next.next;
                                count--;
                                found = true;
                                break;
                            }
                            temp = temp.next;
                        }
                        if (found) System.out.println(">> SUKSES: NIM " + targetNim + " dihapus.");
                        else System.out.println(">> GAGAL: NIM tidak ditemukan.");
                    }
                }
            }

            // 8. SHOW DATA
            else if (choice == 8) {
                System.out.println("\nData Mahasiswa (LinkedList):");
                System.out.println("+-----+--------------+---------------------------+-----+");
                System.out.printf("| %-3s | %-12s | %-25s | %-3s |%n", "No", "NIM", "Nama", "L/P");
                System.out.println("+-----+--------------+---------------------------+-----+");

                if (head == null) {
                    System.out.printf("| %-50s |%n", "                  DATA KOSONG");
                } else {
                    Node temp = head;
                    int i = 1;
                    while (temp != null) {
                        System.out.printf("| %-3d | %-12s | %-25s | %-3s |%n",
                                i, temp.nim, temp.nama, temp.jk);
                        temp = temp.next;
                        i++;
                    }
                }
                System.out.println("+-----+--------------+---------------------------+-----+");
            }

            // 9. EXIT
            else if (choice == 9) {
                System.out.println("Keluar program...");
                break;
            } else {
                System.out.println(">> Menu tidak valid!");
            }
        }
        sc.close();
    }
}