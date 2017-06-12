namespace Ds.DataAccess.EF
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class ds_nhanvien
    {
        public int id { get; set; }

        [StringLength(50)]
        public string ma_nv { get; set; }

        [StringLength(250)]
        public string ten_nv { get; set; }

        public DateTime? ngaysinh { get; set; }

        [StringLength(10)]
        public string gioitinh { get; set; }

        [StringLength(50)]
        public string diachi { get; set; }

        [StringLength(50)]
        public string sdt { get; set; }

        public int trangthai { get; set; }

        public DateTime ngaytao { get; set; }

        public DateTime ngaycapnhat { get; set; }
    }
}
