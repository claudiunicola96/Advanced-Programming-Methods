﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JobDescriptionCsharp.exception
{
    class SheetException : Exception
    {
        public SheetException(string message) : base(message) { }
    }
}
