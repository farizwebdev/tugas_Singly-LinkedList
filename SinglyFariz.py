# CLASS NODE
# Pengganti struct/class di Java
class Node:
    def __init__(self, nim, nama, jk):
        self.nim = nim
        self.nama = nama
        self.jk = jk
        self.next = None  # Pointer ke node berikutnya

# MAIN PROGRAM
if __name__ == "__main__":
    head = None  # Kepala rantai (awalnya kosong)
    count = 0    # Penghitung jumlah data

    # HEADER
    print("\n" + "="*49)
    print("       TUGAS STRUKTUR DATA LINKED LIST           ")
    print("="*49)
    print(" Nama    : Fariz Husain Albar")
    print(" Kelas   : Informatika A")
    print(" NIM     : 24106050011")
    print(" Matkul  : Struktur Data")
    print("="*49)
    input(" >> Tekan ENTER untuk masuk ke Menu Program...")

    while True:
        print(f"\n=== MENU MAHASISWA (Count: {count}) ===")
        print("1. Insert at beginning")
        print("2. Insert at given position")
        print("3. Insert at end")
        print("4. Delete from beginning")
        print("5. Delete given position")
        print("6. Delete from end")
        print("7. Delete first occurence (by NIM)")
        print("8. Show data")
        print("9. Exit")

        try:
            choice_input = input("Pilih menu: ")
            if not choice_input.isdigit():
                print(">> Input salah! Harap masukkan angka.")
                continue
            choice = int(choice_input)
        except ValueError:
            print(">> Input salah! Harap masukkan angka.")
            continue

        # LOGIKA MENU

        # 1. INSERT AT BEGINNING
        if choice == 1:
            # Validasi NIM
            nim = ""
            while True:
                nim = input("Masukkan NIM: ")
                if not nim.isdigit():
                    print(">> ERROR: NIM harus angka!")
                    continue

                # Cek Duplikasi
                exists = False
                temp = head
                while temp is not None:
                    if temp.nim == nim:
                        exists = True
                        break
                    temp = temp.next

                if exists:
                    print(">> ERROR: NIM sudah ada!")
                else:
                    break

            # Validasi Nama
            nama = ""
            while True:
                nama = input("Masukkan Nama: ")
                exists = False
                temp = head
                while temp is not None:
                    if temp.nama.lower() == nama.lower():
                        exists = True
                        break
                    temp = temp.next

                if exists:
                    print(">> ERROR: Nama sudah ada!")
                else:
                    break

            # Validasi JK
            jk = ""
            while True:
                jk = input("Masukkan Jenis Kelamin (L/P): ").upper()
                if jk == "L" or jk == "P":
                    break
                print(">> ERROR: Input salah (L/P)!")

            # PROSES INSERT DEPAN
            new_node = Node(nim, nama, jk)
            if head is None:
                head = new_node
            else:
                new_node.next = head
                head = new_node

            count += 1
            print(">> SUKSES: Data insert di depan.")

        # 2. INSERT AT GIVEN POSITION
        elif choice == 2:
            pos = 0
            while True:
                try:
                    pos_input = input(f"Masukkan Posisi Insert (1 - {count + 1}): ")
                    if not pos_input.isdigit():
                        print(">> ERROR: Harap masukkan angka!")
                        continue
                    pos = int(pos_input)
                    if 1 <= pos <= count + 1:
                        break
                    print(">> ERROR: Posisi tidak valid!")
                except ValueError:
                    print(">> ERROR: Harap masukkan angka!")

            # INPUT DATA SAMA SEPERTI DI ATAS
            nim = ""
            while True:
                nim = input("Masukkan NIM: ")
                if not nim.isdigit(): print(">> ERROR: NIM harus angka!"); continue
                exists = False; temp = head
                while temp:
                    if temp.nim == nim: exists = True; break
                    temp = temp.next
                if exists: print(">> ERROR: NIM sudah ada!");
                else: break

            nama = ""
            while True:
                nama = input("Masukkan Nama: ")
                exists = False; temp = head
                while temp:
                    if temp.nama.lower() == nama.lower(): exists = True; break
                    temp = temp.next
                if exists: print(">> ERROR: Nama sudah ada!");
                else: break

            jk = ""
            while True:
                jk = input("Masukkan Jenis Kelamin (L/P): ").upper()
                if jk in ["L", "P"]: break
                print(">> ERROR: Input salah (L/P)!")

            # PROSES INSERT POSISI
            new_node = Node(nim, nama, jk)
            if pos == 1:
                new_node.next = head
                head = new_node
            else:
                current = head
                # Loop sampai node sebelum posisi target (pos-2 karena index 0)
                for _ in range(1, pos - 1):
                    current = current.next

                new_node.next = current.next
                current.next = new_node

            count += 1
            print(f">> SUKSES: Data insert di posisi {pos}")

        # 3. INSERT AT END
        elif choice == 3:
            # INPUT DATA SAMA
            nim = ""
            while True:
                nim = input("Masukkan NIM: ")
                if not nim.isdigit(): print(">> ERROR: NIM harus angka!"); continue
                exists = False; temp = head
                while temp:
                    if temp.nim == nim: exists = True; break
                    temp = temp.next
                if exists: print(">> ERROR: NIM sudah ada!");
                else: break

            nama = ""
            while True:
                nama = input("Masukkan Nama: ")
                exists = False; temp = head
                while temp:
                    if temp.nama.lower() == nama.lower(): exists = True; break
                    temp = temp.next
                if exists: print(">> ERROR: Nama sudah ada!");
                else: break

            jk = ""
            while True:
                jk = input("Masukkan Jenis Kelamin (L/P): ").upper()
                if jk in ["L", "P"]: break
                print(">> ERROR: Input salah (L/P)!")

            # PROSES INSERT BELAKANG
            new_node = Node(nim, nama, jk)
            if head is None:
                head = new_node
            else:
                temp = head
                while temp.next is not None:
                    temp = temp.next
                temp.next = new_node

            count += 1
            print(">> SUKSES: Data insert di akhir.")

        # 4. DELETE FROM BEGINNING
        elif choice == 4:
            if head is None:
                print(">> GAGAL: LinkedList Kosong!")
            else:
                head = head.next
                count -= 1
                print(">> SUKSES: Data pertama dihapus.")

        # 5. DELETE GIVEN POSITION
        elif choice == 5:
            if head is None:
                print(">> GAGAL: LinkedList Kosong!")
            else:
                pos = 0
                while True:
                    try:
                        pos_input = input(f"Masukkan Posisi Hapus (1 - {count}): ")
                        if not pos_input.isdigit():
                            print(">> ERROR: Harap masukkan angka!")
                            continue
                        pos = int(pos_input)
                        if 1 <= pos <= count: break
                        print(">> ERROR: Posisi tidak valid!")
                    except ValueError:
                        print(">> ERROR: Harap masukkan angka!")

                if pos == 1:
                    head = head.next
                else:
                    temp = head
                    for _ in range(1, pos - 1):
                        temp = temp.next

                    # Skip node yang dihapus
                    node_to_delete = temp.next
                    temp.next = node_to_delete.next

                count -= 1
                print(f">> SUKSES: Data posisi {pos} dihapus.")

        # 6. DELETE FROM END
        elif choice == 6:
            if head is None:
                print(">> GAGAL: LinkedList Kosong!")
            elif head.next is None:
                head = None
                count -= 1
                print(">> SUKSES: Data terakhir dihapus.")
            else:
                temp = head
                while temp.next.next is not None:
                    temp = temp.next

                temp.next = None
                count -= 1
                print(">> SUKSES: Data terakhir dihapus.")

        # 7. DELETE FIRST OCCURRENCE (BY NIM)
        elif choice == 7:
            if head is None:
                print(">> GAGAL: LinkedList Kosong!")
            else:
                target_nim = input("Masukkan NIM yang akan dihapus: ")

                if head.nim == target_nim:
                    head = head.next
                    count -= 1
                    print(f">> SUKSES: NIM {target_nim} dihapus.")
                else:
                    temp = head
                    found = False
                    while temp.next is not None:
                        if temp.next.nim == target_nim:
                            temp.next = temp.next.next
                            count -= 1
                            found = True
                            break
                        temp = temp.next

                    if found:
                        print(f">> SUKSES: NIM {target_nim} dihapus.")
                    else:
                        print(">> GAGAL: NIM tidak ditemukan.")

        # 8. SHOW DATA
        elif choice == 8:
            print("\nData Mahasiswa (LinkedList):")
            print("+-----+--------------+---------------------------+-----+")
            print(f"| {'No':<3} | {'NIM':<12} | {'Nama':<25} | {'L/P':<3} |")
            print("+-----+--------------+---------------------------+-----+")

            if head is None:
                print(f"| {'DATA KOSONG':^50} |")
            else:
                temp = head
                i = 1
                while temp is not None:
                    print(f"| {i:<3} | {temp.nim:<12} | {temp.nama:<25} | {temp.jk:<3} |")
                    temp = temp.next
                    i += 1
            print("+-----+--------------+---------------------------+-----+")

        # 9. EXIT
        elif choice == 9:
            print("Keluar program...")
            break

        else:
            print(">> Menu tidak valid!")